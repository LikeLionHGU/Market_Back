package org.example.marketback.scheduler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.marketback.entity.History;
import org.example.marketback.entity.Market;
import org.example.marketback.entity.Tmi;
import org.example.marketback.repository.HistoryRepository;
import org.example.marketback.repository.MarketRepository;
import org.example.marketback.repository.TmiRepository;
import org.example.marketback.service.AiSummaryService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j // 로그 출력을 위해 추가
@Component
@RequiredArgsConstructor
public class HistoryUpdateScheduler {

    private final MarketRepository marketRepository;
    private final TmiRepository tmiRepository;
    private final HistoryRepository historyRepository; // History 저장을 위해 추가
    private final AiSummaryService aiSummaryService;

    // 매일 새벽 5시에 실행 (초 분 시 일 월 요일)
    @Scheduled(cron = "0 0 5 * * *", zone = "Asia/Seoul")
    @Transactional
    public void updateHistoriesWithTmiSummaries() {
        log.info("AI 기반 일일 히스토리 업데이트 작업을 시작합니다...");

        // 1. 어제 날짜 계산
        LocalDate yesterday = LocalDate.now().minusDays(1);
        LocalDateTime startOfYesterday = yesterday.atStartOfDay(); // 어제 00:00:00
        LocalDateTime endOfYesterday = yesterday.atTime(23, 59, 59); // 어제 23:59:59

        // 2. 모든 마켓 정보를 가져옴
        List<Market> allMarkets = marketRepository.findAll();

        for (Market market : allMarkets) {
            // 3. 각 마켓별로 어제 작성된 TMI들을 조회
            List<Tmi> yesterdaysTmis = tmiRepository.findAllByMarketAndCreatedDateBetween(market, startOfYesterday, endOfYesterday);

            // 4. 어제 작성된 TMI가 없으면 다음 마켓으로 넘어감
            if (yesterdaysTmis.isEmpty()) {
                log.info("'{}' 마켓은 어제 새로운 TMI가 없어 건너뜁니다.", market.getName());
                continue;
            }

            // 5. TMI 내용들을 하나의 문자열로 합침
            String tmiContent = yesterdaysTmis.stream()
                    .map(tmi -> "제목: " + tmi.getTitle() + "\n내용: " + tmi.getContent())
                    .collect(Collectors.joining("\n\n---\n\n"));

            log.info("'{}' 마켓의 TMI 요약을 AI에게 요청합니다...", market.getName());

            // 6. AI 서비스에 요약을 요청
            String summary = aiSummaryService.summarize(market.getName(), tmiContent);

            // 7. 해당 마켓의 히스토리를 찾거나, 없으면 새로 생성
            History history = historyRepository.findById(market.getId())
                    .orElse(new History(market.getId(), market, ""));

            // 8. AI가 생성한 요약으로 히스토리 내용을 업데이트
            history.setContent(summary);
            historyRepository.save(history);

            log.info("'{}' 마켓의 히스토리가 성공적으로 업데이트되었습니다.", market.getName());
        }

        log.info("AI 기반 일일 히스토리 업데이트 작업을 완료했습니다.");
    }
}
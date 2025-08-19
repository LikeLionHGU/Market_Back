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

@Slf4j
@Component
@RequiredArgsConstructor
public class HistoryUpdateScheduler {

    private final MarketRepository marketRepository;
    private final TmiRepository tmiRepository;
    private final HistoryRepository historyRepository;
    private final AiSummaryService aiSummaryService;

    @Scheduled(cron = "0 06 20 * * *", zone = "Asia/Seoul")
    @Transactional
    public void updateHistoriesWithTmiSummaries() {
        log.info("AI 기반 일일 히스토리 업데이트 작업을 시작합니다..");

        LocalDateTime startOfRange = LocalDate.now().minusDays(1).atStartOfDay();
        LocalDateTime endOfRange = LocalDateTime.now();

        List<Market> allMarkets = marketRepository.findAll();

        for (Market market : allMarkets) {
            List<Tmi> newTmis = tmiRepository.findAllByMarketAndCreatedDateBetween(market, startOfRange, endOfRange);

            if (newTmis.isEmpty()) {
                log.info("'{}' 마켓은 새로운 TMI가 없어 건너뜁니다.", market.getName());
                continue;
            }

            // AI 요약 요청 전에 기존 히스토리를 조회합니다.
            History existingHistoryEntity = historyRepository.findById(market.getId()).orElse(null);
            String originalHistory = (existingHistoryEntity != null && existingHistoryEntity.getContent() != null)
                    ? existingHistoryEntity.getContent()
                    : "이 가게에 대한 과거 기록이 아직 없습니다.";

            // 새로 수집된 TMI(후기)들을 하나의 문자열로 합칩니다.
            String userReviews = newTmis.stream()
                    .map(tmi -> "제목: " + tmi.getTitle() + "\n내용: " + tmi.getContent())
                    .collect(Collectors.joining("\n\n---\n\n"));

            log.info("'{}' 마켓의 히스토리 각색을 AI에게 요청합니다...", market.getName());

            // AI 서비스에 '기존 히스토리'와 '새로운 후기'를 모두 전달합니다.
            String newStory = aiSummaryService.summarize(market.getName(), originalHistory, userReviews);

            // 기존 히스토리 엔티티가 있으면 재사용하고, 없으면 새로 생성합니다.
            History historyToUpdate = (existingHistoryEntity != null)
                    ? existingHistoryEntity
                    : new History(market.getId(), market, "");

            // AI가 생성한 새로운 이야기로 히스토리 내용을 업데이트합니다.
            historyToUpdate.setContent(newStory);
            historyRepository.save(historyToUpdate);

            log.info("'{}' 마켓의 히스토리가 성공적으로 업데이트되었습니다.", market.getName());
        }

        log.info("AI 기반 일일 히스토리 업데이트 작업을 완료했습니다.");
    }
}
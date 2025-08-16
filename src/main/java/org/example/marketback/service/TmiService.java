package org.example.marketback.service;

import lombok.RequiredArgsConstructor;
import org.example.marketback.controller.request.TmiCreateRequest;
import org.example.marketback.entity.Market;
import org.example.marketback.entity.Tmi;
import org.example.marketback.exception.MarketNotFoundException;
import org.example.marketback.repository.MarketRepository;
import org.example.marketback.repository.TmiRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.example.marketback.exception.TmiNotFoundException;

@Service
@RequiredArgsConstructor
public class TmiService {

    private final TmiRepository tmiRepository;
    private final MarketRepository marketRepository;

    @Transactional
    public Tmi createTmi(TmiCreateRequest req) {
        Market market = marketRepository.findById(req.getMarketId())
                .orElseThrow(MarketNotFoundException::new);

        Tmi newTmi = Tmi.builder()
                .title(req.getTitle())
                .content(req.getContent())
                .category(req.getCategory())
                .market(market)
                .likes(0L)
                .views(0L)
                .build();

        return tmiRepository.save(newTmi);
    }

    @Transactional // readOnly = true 삭제
    public Tmi getTmiById(Long tmiId) {
        Tmi tmi = tmiRepository.findById(tmiId)
                .orElseThrow(TmiNotFoundException::new);

        tmi.increaseViewCount(); // 조회수 증가 로직 추가

        return tmi;
    }

    @Transactional
    public Tmi likeTmi(Long tmiId) {
        Tmi tmi = tmiRepository.findById(tmiId)
                .orElseThrow(TmiNotFoundException::new);

        tmi.increaseLikeCount(); // 좋아요 증가

        return tmi; // 변경된 tmi 객체 반환
    }

}
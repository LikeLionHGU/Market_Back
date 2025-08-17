package org.example.marketback.service;

import lombok.RequiredArgsConstructor;
import org.example.marketback.controller.request.TmiCreateRequest;
import org.example.marketback.dto.TmiDto; // Dto import 추가
import org.example.marketback.entity.Market;
import org.example.marketback.entity.Tmi;
import org.example.marketback.exception.MarketNotFoundException;
import org.example.marketback.exception.TmiNotFoundException;
import org.example.marketback.repository.MarketRepository;
import org.example.marketback.repository.TmiRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public TmiDto getTmiById(Long tmiId) { // 반환 타입을 TmiDto로 변경
        Tmi tmi = tmiRepository.findById(tmiId)
                .orElseThrow(TmiNotFoundException::new);

        tmi.increaseViewCount();

        // 트랜잭션 안에서 DTO로 변환 후 반환
        return TmiDto.of(tmi);
    }

    @Transactional
    public TmiDto likeTmi(Long tmiId) { // 반환 타입을 TmiDto로 변경
        Tmi tmi = tmiRepository.findById(tmiId)
                .orElseThrow(TmiNotFoundException::new);

        tmi.increaseLikeCount();

        // 트랜잭션 안에서 DTO로 변환 후 반환
        return TmiDto.of(tmi);
    }
}
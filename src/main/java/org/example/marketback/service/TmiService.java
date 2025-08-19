package org.example.marketback.service;

import lombok.RequiredArgsConstructor;
import org.example.marketback.controller.request.TmiCreateRequest;
import org.example.marketback.dto.TmiDto; // Dto import 추가
import org.example.marketback.entity.Market;
import org.example.marketback.entity.Tmi;
import org.example.marketback.entity.enums.Category;
import org.example.marketback.exception.MarketNotFoundException;
import org.example.marketback.exception.TmiNotFoundException;
import org.example.marketback.repository.MarketRepository;
import org.example.marketback.repository.TmiRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
                .email(req.getEmail())
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

    @Transactional(readOnly = true)
    // 메소드 이름과 파라미터를 명확하게 수정
    public List<TmiDto> getTmisByMarketAndCategory(Long marketId, Category category) {
        // 1. marketId로 Market 엔티티를 조회
        Market market = marketRepository.findById(marketId)
                .orElseThrow(MarketNotFoundException::new);

        List<Tmi> tmis;

        // 2. "전체" 카테고리인 경우 해당 마켓의 모든 TMI를 조회
        if (category == Category.전체) {
            tmis = tmiRepository.findAllByMarket(market);
        } else {
            // 3. 그 외 카테고리는 해당 마켓의 특정 카테고리 TMI만 조회
            tmis = tmiRepository.findByMarketAndCategory(market, category);
        }

        // 조회된 Tmi 엔티티 리스트를 TmiDto 리스트로 변환하여 반환
        return tmis.stream()
                .map(TmiDto::of)
                .collect(Collectors.toList());
    }
}
package org.example.marketback.service;

import lombok.RequiredArgsConstructor;
import org.example.marketback.dto.MarketDto;
import org.example.marketback.entity.Market;
import org.example.marketback.exception.MarketNotFoundException;
import org.example.marketback.repository.MarketRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // import 추가

import java.io.IOException;
@Service
@RequiredArgsConstructor
public class MarketService {
    private final MarketRepository marketRepository;

    @Transactional(readOnly = true) // <-- 이 어노테이션을 추가하세요!
    public MarketDto getMarketInfo(Long marketId) {
        Market market = marketRepository.findById(marketId)
                .orElseThrow(MarketNotFoundException::new);
        // 트랜잭션 범위 안에서 DTO 변환이 일어나므로 tmiList에 정상적으로 접근 가능
        return MarketDto.of(market);
    }

}
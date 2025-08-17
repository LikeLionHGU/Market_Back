package org.example.marketback.service;

import lombok.RequiredArgsConstructor;
import org.example.marketback.dto.*;
import org.example.marketback.entity.Market;
import org.example.marketback.entity.Tmi;
import org.example.marketback.exception.MarketNotFoundException;
import org.example.marketback.repository.MarketRepository;
import org.example.marketback.repository.TmiRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MarketService {

    private final MarketRepository marketRepository;
    private final TmiRepository tmiRepository;

    public List<MarketSimpleDto> getAllMarkets() {
        return marketRepository.findAll().stream()
                .map(MarketSimpleDto::new)
                .collect(Collectors.toList());
    }

    public MarketDto getMarketInfo(Long marketId) {
        Market market = marketRepository.findById(marketId)
                .orElseThrow(MarketNotFoundException::new);
        return MarketDto.of(market);
    }

    public List<TmiTopDto> getMarketTopTmis(Long marketId) {
        Market market = marketRepository.findById(marketId)
                .orElseThrow(MarketNotFoundException::new);

        return tmiRepository.findTop3ByMarketOrderByLikesDesc(market).stream()
                .map(TmiTopDto::new)
                .collect(Collectors.toList());
    }

    public List<TmiDto> getMarketAllTmis(Long marketId) {
        Market market = marketRepository.findById(marketId)
                .orElseThrow(MarketNotFoundException::new);

        return tmiRepository.findAllByMarket(market).stream()
                .map(TmiDto::of)
                .collect(Collectors.toList());
    }

    public List<NeighborMarketDto> getNeighborMarkets(Long marketId) {
        // 1. 기준이 되는 마켓을 찾습니다.
        Market currentMarket = marketRepository.findById(marketId)
                .orElseThrow(MarketNotFoundException::new);

        // 2. 기준 마켓과 동일한 카테고리를 가진 다른 마켓들을 모두 찾습니다.
        List<Market> neighbors = marketRepository.findByCategoryAndIdNot(
                currentMarket.getCategory(),
                currentMarket.getId()
        );

        // 3. 각 이웃 마켓들의 Top TMI를 찾아 DTO로 만듭니다.
        return neighbors.stream()
                .map(neighbor -> {
                    // 3-1. 각 이웃 마켓의 좋아요 1등 TMI를 찾습니다.
                    Optional<Tmi> topTmiOpt = tmiRepository.findTopByMarketOrderByLikesDesc(neighbor);

                    // 3-2. Top TMI가 있으면 DTO로 만들고, 없으면 null로 설정합니다.
                    TmiTopDto topTmiDto = topTmiOpt.map(TmiTopDto::new).orElse(null);

                    // 3-3. 최종 NeighborMarketDto로 만듭니다.
                    return new NeighborMarketDto(neighbor, topTmiDto);
                })
                .collect(Collectors.toList());
    }
}
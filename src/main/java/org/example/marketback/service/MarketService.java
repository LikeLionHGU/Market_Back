package org.example.marketback.service;

import lombok.RequiredArgsConstructor;
import org.example.marketback.dto.MarketDetailDto;
import org.example.marketback.dto.MarketSummaryDto;
import org.example.marketback.dto.TMIDto;
import org.example.marketback.entity.Market;
import org.example.marketback.repository.HistoryRepository;
import org.example.marketback.repository.MarketRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MarketService {
    
    private final MarketRepository marketRepository;
    private final HistoryRepository historyRepository;
    
    public List<MarketSummaryDto> getAllMarkets() {
        return marketRepository.findAll().stream()
                .map(this::convertToSummaryDto)
                .collect(Collectors.toList());
    }
    
    @Transactional
    public MarketDetailDto getMarketDetail(Long marketId) {
        Market market = marketRepository.findById(marketId)
                .orElseThrow(() -> new RuntimeException("Market not found with id: " + marketId));
        
        // Get TMI list separately
        List<TMIDto> tmiList = historyRepository.findByMarketIdOrderByHistoryIdDesc(marketId).stream()
                .map(history -> TMIDto.builder()
                        .historyId(history.getHistoryId())
                        .content(history.getContent())
                        .countLike(history.getCountLike())
                        .viewCount(history.getViewCount())
                        .marketName(market.getName())
                        .build())
                .collect(Collectors.toList());
        
        return MarketDetailDto.builder()
                .id(market.getId())
                .name(market.getName())
                .history(market.getHistory())
                .address(market.getAddress())
                .contact(market.getContact())
                .imageUrls(new ArrayList<>()) // Empty for now
                .workingDates(new ArrayList<>()) // Empty for now
                .tmiList(tmiList)
                .build();
    }
    
    private MarketSummaryDto convertToSummaryDto(Market market) {
        return MarketSummaryDto.builder()
                .id(market.getId())
                .name(market.getName())
                .address(market.getAddress())
                .contact(market.getContact())
                .imageUrls(new ArrayList<>()) // Empty for now
                .build();
    }
}
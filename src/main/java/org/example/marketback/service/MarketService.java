package org.example.marketback.service;

import lombok.RequiredArgsConstructor;
import org.example.marketback.dto.MarketDetailDto;
import org.example.marketback.dto.MarketSummaryDto;
import org.example.marketback.dto.TMIDto;
import org.example.marketback.entity.Market;
import org.example.marketback.repository.MarketRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MarketService {
    
    private final MarketRepository marketRepository;
    
    public List<MarketSummaryDto> getAllMarkets() {
        return marketRepository.findAll().stream()
                .map(this::convertToSummaryDto)
                .collect(Collectors.toList());
    }
    
    public MarketDetailDto getMarketDetail(Long marketId) {
        Market market = marketRepository.findById(marketId)
                .orElseThrow(() -> new RuntimeException("Market not found with id: " + marketId));
        
        return convertToDetailDto(market);
    }
    
    private MarketSummaryDto convertToSummaryDto(Market market) {
        List<String> imageUrls = market.getImages().stream()
                .map(image -> image.getImageURL())
                .collect(Collectors.toList());
        
        return MarketSummaryDto.builder()
                .id(market.getId())
                .name(market.getName())
                .address(market.getAddress())
                .contact(market.getContact())
                .imageUrls(imageUrls)
                .build();
    }
    
    private MarketDetailDto convertToDetailDto(Market market) {
        List<String> imageUrls = market.getImages().stream()
                .map(image -> image.getImageURL())
                .collect(Collectors.toList());
        
        List<MarketDetailDto.WorkingDateDto> workingDates = market.getDates().stream()
                .map(wd -> MarketDetailDto.WorkingDateDto.builder()
                        .day(wd.getDay())
                        .start(wd.getStart())
                        .end(wd.getEnd())
                        .build())
                .collect(Collectors.toList());
        
        List<TMIDto> tmiList = market.getHistoryList().stream()
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
                .imageUrls(imageUrls)
                .workingDates(workingDates)
                .tmiList(tmiList)
                .build();
    }
}
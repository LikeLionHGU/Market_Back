package org.example.marketback.service;

import lombok.RequiredArgsConstructor;
import org.example.marketback.dto.TMICreateRequest;
import org.example.marketback.dto.TMICurationDto;
import org.example.marketback.dto.TMIDto;
import org.example.marketback.entity.History;
import org.example.marketback.entity.Market;
import org.example.marketback.repository.HistoryRepository;
import org.example.marketback.repository.MarketRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TMIService {
    
    private final HistoryRepository historyRepository;
    private final MarketRepository marketRepository;
    
    public TMICurationDto getCuratedTMI() {
        List<TMIDto> recentTMI = historyRepository.findTop2ByOrderByHistoryIdDesc().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        
        List<TMIDto> popularTMI = historyRepository.findTop2ByOrderByViewCountDesc().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        
        return TMICurationDto.builder()
                .recentTMI(recentTMI)
                .popularTMI(popularTMI)
                .build();
    }
    
    @Transactional
    public TMIDto createTMI(TMICreateRequest request) {
        Market market = marketRepository.findById(request.getMarketId())
                .orElseThrow(() -> new RuntimeException("Market not found with id: " + request.getMarketId()));
        
        History history = History.builder()
                .content(request.getContent())
                .countLike(0)
                .viewCount(0)
                .market(market)
                .build();
        
        History savedHistory = historyRepository.save(history);
        return convertToDto(savedHistory);
    }
    
    @Transactional
    public TMIDto getTMIDetail(Long historyId) {
        History history = historyRepository.findById(historyId)
                .orElseThrow(() -> new RuntimeException("TMI not found with id: " + historyId));
        
        // Increment view count
        history.plusViewCount();
        historyRepository.save(history);
        
        return convertToDto(history);
    }
    
    private TMIDto convertToDto(History history) {
        return TMIDto.builder()
                .historyId(history.getHistoryId())
                .content(history.getContent())
                .countLike(history.getCountLike())
                .viewCount(history.getViewCount())
                .marketName(history.getMarket() != null ? history.getMarket().getName() : null)
                .build();
    }
}
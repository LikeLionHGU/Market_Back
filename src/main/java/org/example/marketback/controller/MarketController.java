package org.example.marketback.controller;

import lombok.RequiredArgsConstructor;
import org.example.marketback.dto.MarketDetailDto;
import org.example.marketback.dto.MarketSummaryDto;
import org.example.marketback.service.MarketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/markets")
@RequiredArgsConstructor
public class MarketController {
    
    private final MarketService marketService;
    
    @GetMapping
    public ResponseEntity<List<MarketSummaryDto>> getAllMarkets() {
        List<MarketSummaryDto> markets = marketService.getAllMarkets();
        return ResponseEntity.ok(markets);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<MarketDetailDto> getMarketDetail(@PathVariable Long id) {
        MarketDetailDto marketDetail = marketService.getMarketDetail(id);
        return ResponseEntity.ok(marketDetail);
    }
}
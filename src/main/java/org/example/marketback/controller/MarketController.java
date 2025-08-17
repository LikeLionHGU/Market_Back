package org.example.marketback.controller;

import lombok.RequiredArgsConstructor;
import org.example.marketback.controller.response.MarketResponse;
import org.example.marketback.dto.MarketDto;
import org.example.marketback.dto.MarketSimpleDto;
import org.example.marketback.dto.NeighborMarketDto;
import org.example.marketback.dto.TmiTopDto;
import org.example.marketback.service.MarketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.example.marketback.dto.TmiDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/market")
public class MarketController {

    private final MarketService marketService;

    // tmi에서 어디였나요? 부분에 띄워주기 위해서 DB에서 가게 정보 모두 보여주는 API
    @GetMapping("/alls")
    public ResponseEntity<List<MarketSimpleDto>> getAllMarkets() {
        List<MarketSimpleDto> markets = marketService.getAllMarkets();
        return ResponseEntity.ok(markets);
    }

    // 가게 상세 정보 API
    @GetMapping("/info/{marketId}")
    public ResponseEntity<MarketResponse> getMarketInfo(@PathVariable Long marketId) {
        MarketDto marketDto = marketService.getMarketInfo(marketId);
        MarketResponse response = new MarketResponse(marketDto);
        return ResponseEntity.ok(response);
    }

    // 해당 가게에서 좋아요 가장 많은 거 3개 제목 + 내용 보내주는 API
    @GetMapping("/topTmi/{marketId}")
    public ResponseEntity<List<TmiTopDto>> getMarketTopTmi(@PathVariable Long marketId) {
        List<TmiTopDto> topTmis = marketService.getMarketTopTmis(marketId);
        return ResponseEntity.ok(topTmis);
    }

    // 해당 가게 tmi 전부 보내주는 API
    @GetMapping("/tmi/{marketId}")
    public ResponseEntity<List<TmiDto>> getMarketTmi(@PathVariable Long marketId) {
        List<TmiDto> tmis = marketService.getMarketAllTmis(marketId);
        return ResponseEntity.ok(tmis);
    }

    // 이 가게랑 같은 카테고리에 속한 가게들 정보 보내주는 API
    @GetMapping("/neighbors/{marketId}")
    public ResponseEntity<List<NeighborMarketDto>> getMarketNeighbors(@PathVariable Long marketId) {
        List<NeighborMarketDto> neighbors = marketService.getNeighborMarkets(marketId);
        return ResponseEntity.ok(neighbors);
    }
}
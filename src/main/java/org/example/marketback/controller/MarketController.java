package org.example.marketback.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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

@Tag(name = "마켓", description = "마켓 관련 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/market")
public class MarketController {

    private final MarketService marketService;

    @Operation(summary = "전체 마켓 목록 조회", description = "TMI 작성 시 선택할 수 있는 모든 마켓의 간단한 정보를 조회합니다")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 조회됨"),
            @ApiResponse(responseCode = "500", description = "서버 내부 오류")
    })
    @GetMapping("/alls")
    public ResponseEntity<List<MarketSimpleDto>> getAllMarkets() {
        List<MarketSimpleDto> markets = marketService.getAllMarkets();
        return ResponseEntity.ok(markets);
    }

    @Operation(summary = "마켓 상세 정보 조회", description = "특정 마켓의 상세 정보를 조회합니다")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 조회됨"),
            @ApiResponse(responseCode = "404", description = "해당 ID의 마켓을 찾을 수 없음"),
            @ApiResponse(responseCode = "500", description = "서버 내부 오류")
    })
    @GetMapping("/info/{marketId}")
    public ResponseEntity<MarketResponse> getMarketInfo(
            @Parameter(description = "마켓 ID", required = true) @PathVariable Long marketId) {
        MarketDto marketDto = marketService.getMarketInfo(marketId);
        MarketResponse response = new MarketResponse(marketDto);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "마켓 인기 TMI 조회", description = "특정 마켓에서 좋아요가 가장 많은 TMI 3개를 조회합니다")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 조회됨"),
            @ApiResponse(responseCode = "404", description = "마켓을 찾을 수 없음"),
            @ApiResponse(responseCode = "500", description = "서버 오류")
    })
    @GetMapping("/topTmi/{marketId}")
    public ResponseEntity<List<TmiTopDto>> getMarketTopTmi(
            @Parameter(description = "마켓 ID", required = true) @PathVariable Long marketId) {
        List<TmiTopDto> topTmis = marketService.getMarketTopTmis(marketId);
        return ResponseEntity.ok(topTmis);
    }

    @Operation(summary = "마켓 전체 TMI 조회", description = "특정 마켓의 모든 TMI를 조회합니다")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 조회됨"),
            @ApiResponse(responseCode = "404", description = "마켓을 찾을 수 없음"),
            @ApiResponse(responseCode = "500", description = "서버 오류")
    })
    @GetMapping("/tmi/{marketId}")
    public ResponseEntity<List<TmiDto>> getMarketTmi(
            @Parameter(description = "마켓 ID", required = true) @PathVariable Long marketId) {
        List<TmiDto> tmis = marketService.getMarketAllTmis(marketId);
        return ResponseEntity.ok(tmis);
    }

    @Operation(summary = "유사 마켓 조회", description = "특정 마켓과 같은 카테고리에 속한 다른 마켓들을 조회합니다")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 조회됨"),
            @ApiResponse(responseCode = "404", description = "마켓을 찾을 수 없음"),
            @ApiResponse(responseCode = "500", description = "서버 오류")
    })
    @GetMapping("/neighbors/{marketId}")
    public ResponseEntity<List<NeighborMarketDto>> getMarketNeighbors(
            @Parameter(description = "마켓 ID", required = true) @PathVariable Long marketId) {
        List<NeighborMarketDto> neighbors = marketService.getNeighborMarkets(marketId);
        return ResponseEntity.ok(neighbors);
    }
}
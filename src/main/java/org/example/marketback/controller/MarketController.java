package org.example.marketback.controller;

import lombok.RequiredArgsConstructor;
import org.example.marketback.controller.response.MarketResponse;
import org.example.marketback.dto.MarketDto;
import org.example.marketback.entity.Market;
import org.example.marketback.service.MarketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/market")
public class MarketController {

    private final MarketService marketService;


    // tmi에서 어디였나요? 부분에 띄워주기 위해서 DB에서 가게 정보 모두 보여줘야함.
    @GetMapping("/alls")
    public ResponseEntity<MarketDto> getAllMarkets() {
        return null;
    }

    // 가게 상세 페이지 (api 3개로 나눠 개발해야하지 않을까.. 음..)

    // 1번 api
    // 가게 이름 받아와서 작업하면 될 듯
    // 가게 이름 받아오면, 가게이름+운영시간+가게주소+히스토리+사진
    @GetMapping("/info/{marketId}") // 가게 상세정보 완료
    public ResponseEntity<MarketResponse> getMarketInfo(@PathVariable Long marketId) {
        MarketDto marketDto = marketService.getMarketInfo(marketId);
        MarketResponse response = new MarketResponse(marketDto);
        return ResponseEntity.ok(response);
    }


    // 2번 api
    // 가게 이름 + 카테고리명 받아서 정렬 (최신 순서로) 해서 보내주는 api -> 하루마다 업데이트 하게!

    // 3번 api
    // 해당 가게에서 좋아요 가장 많은 거 3개 제목 + 내용 보내주는 api
    @GetMapping("/topTmi/{marketId}") //가게에서 좋아요 가장 많은 거 3개 제목 + 내용 보내주는
    public ResponseEntity<MarketDto> getMarketTopTmi() {
        return null;
    }

    @GetMapping("/tmi/{marketId}") //해당 가게 tmi 전부 보내주는 api
    public ResponseEntity<MarketDto> getMarketTmi() {
        return null;
    }

    // 4번 api
    // 이 가게랑 같은 카테고리에 속한 가게들 사진+이름+tmi(좋아요 가장 많은 거)1개 보내주는 api
    @GetMapping("/neighbors/{marketId}") // 이 가게랑 같은 카테고리에 속한 가게들
    public ResponseEntity<MarketDto> getMarketNeighbors() {
        return null;
    }

}

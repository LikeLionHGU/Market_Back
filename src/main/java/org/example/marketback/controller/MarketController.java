package org.example.marketback.controller;

import lombok.RequiredArgsConstructor;
import org.example.marketback.dto.MarketDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/market")
public class MarketController {

    // tmi에서 어디였나요? 부분에 띄워주기 위해서 DB에서 가게 정보 모두 보여줘야함.
    @GetMapping("/alls")
    public ResponseEntity<MarketDto.MarketAllResDto> getAllMarkets() {
        return null;
    }

    // 가게 상세 페이지 (api 3개로 나눠 개발해야하지 않을까.. 음..)

    // 1번 api
    // 가게 이름 받아와서 작업하면 될 듯
    // 가게 이름 받아오면, 가게이름+운영시간+가게주소+히스토리+사진

    // 2번 api
    // 가게 이름 + 카테고리명 받아서 정렬 (최신 순서로) 해주는 api

    // 3번 api
    // 이 가게에서 좋아요 가장 많은 거 3개 제목 + 내용 보내주는 api

    // 4번 api
    // 이 가게랑 같은 카테고리에 속한 가게들 사진+이름+tmi(좋아요 가장 많은 거)1개 보내주는 api


}

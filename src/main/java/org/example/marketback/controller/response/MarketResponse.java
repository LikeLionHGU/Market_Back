package org.example.marketback.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.marketback.dto.MarketDto;
import org.example.marketback.dto.TmiDto; // import 추가

import java.util.List; // import 추가

@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@AllArgsConstructor
public class MarketResponse {

    private Long id;
    private String name;
    private String phoneNumber;
    private String address;
    private String openTime;
    private String marketImg;
    private String marketLogo;
    private String  foodMenuImg;
    private String info;
    private String color;
    private String history;
    private String chipColor;
    private List<TmiDto> tmiList;


    public MarketResponse(MarketDto marketDto) {
        this.id = marketDto.getId();
        this.name = marketDto.getName();
        this.phoneNumber = marketDto.getPhoneNumber();
        this.address = marketDto.getAddress();
        this.openTime = marketDto.getOpenTime();
        this.marketImg = marketDto.getMarketImg();
        this.marketLogo = marketDto.getMarketLogo();
        this.info = marketDto.getInfo();
        this.foodMenuImg = marketDto.getFoodMenuImg();
        this.color = marketDto.getColor();
        this.history = marketDto.getHistory();
        this.chipColor = marketDto.getChipColor();
        this.tmiList = marketDto.getTmiList(); // <-- 생성자에서 값을 매핑하세요!
    }
}
package org.example.marketback.dto;

import lombok.*;
import org.example.marketback.entity.Market;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MarketDto {

    private Long id;
    private String name;
    private String phoneNumber;
    private String address;
    private String openTime;
    private String marketImg;
    private String marketLogo;
    private String info;
    private String foodMenuImg;
    private String history;
    private String color;
    private String chipColor;
    private List<TmiDto> tmiList;

    public static MarketDto of(Market market) {

        String historyContent = (market.getHistory() != null)
                ? market.getHistory().getContent()
                : null;

        List<TmiDto> tmiDtos = market.getTmiList().stream()
                .map(TmiDto::of)
                .collect(Collectors.toList());

        return MarketDto.builder()
                .id(market.getId())
                .name(market.getName())
                .phoneNumber(market.getPhoneNumber())
                .address(market.getAddress())
                .openTime(market.getOpenTime())
                .marketImg(market.getMarketImg())
                .marketLogo(market.getMarketLogo())
                .info(market.getInfo())
                .foodMenuImg(market.getFoodMenuImg()) // <-- 누락되었던 필드 추가
                .color(market.getColor())
                .chipColor(market.getChipColor())
                .history(historyContent)
                .tmiList(tmiDtos)
                .build();
    }
}
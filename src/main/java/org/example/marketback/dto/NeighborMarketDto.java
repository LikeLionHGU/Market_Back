package org.example.marketback.dto;

import lombok.Getter;
import org.example.marketback.entity.Market;

@Getter
public class NeighborMarketDto {
    private Long id;
    private String name;
    private String marketImg;
    private TmiTopDto topTmi;

    public NeighborMarketDto(Market market, TmiTopDto topTmi) {
        this.id = market.getId();
        this.name = market.getName();
        this.marketImg = market.getMarketImg();
        this.topTmi = topTmi;
    }
}
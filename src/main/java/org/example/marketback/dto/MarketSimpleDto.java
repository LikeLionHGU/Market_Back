package org.example.marketback.dto;

import lombok.Getter;
import org.example.marketback.entity.Market;

@Getter
public class MarketSimpleDto {
    private Long id;
    private String name;

    public MarketSimpleDto(Market market) {
        this.id = market.getId();
        this.name = market.getName();
    }
}
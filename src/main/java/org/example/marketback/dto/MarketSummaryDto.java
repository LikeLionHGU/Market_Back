package org.example.marketback.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MarketSummaryDto {
    private Long id;
    private String name;
    private String address;
    private String contact;
    private List<String> imageUrls;
}
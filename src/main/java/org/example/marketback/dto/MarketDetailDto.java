package org.example.marketback.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MarketDetailDto {
    private Long id;
    private String name;
    private String history;
    private String address;
    private String contact;
    private List<String> imageUrls;
    private List<WorkingDateDto> workingDates;
    private List<TMIDto> tmiList;
    
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class WorkingDateDto {
        private DayOfWeek day;
        private LocalTime start;
        private LocalTime end;
    }
}
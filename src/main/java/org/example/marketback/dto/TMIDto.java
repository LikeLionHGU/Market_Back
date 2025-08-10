package org.example.marketback.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TMIDto {
    private Long historyId;
    private String content;
    private int countLike;
    private long viewCount;
    private String marketName;
}
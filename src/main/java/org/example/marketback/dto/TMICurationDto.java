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
public class TMICurationDto {
    private List<TMIDto> recentTMI;
    private List<TMIDto> popularTMI;
}
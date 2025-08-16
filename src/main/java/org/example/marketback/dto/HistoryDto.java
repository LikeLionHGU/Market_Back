package org.example.marketback.dto;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.*;
import org.example.marketback.entity.Market;
import org.example.marketback.entity.TmiComment;
import org.example.marketback.entity.enums.Category;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoryDto {

    private Long id;
    private String marketName;

    private String content;
}
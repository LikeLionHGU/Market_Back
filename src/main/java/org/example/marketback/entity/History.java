package org.example.marketback.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class History extends Base {

    @Id
    private Long id;

    @OneToOne
    @MapsId // Market의 ID를 이 엔티티의 ID로 사용
    @JoinColumn(name = "id")
    private Market market;

    private String content;

}
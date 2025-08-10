package org.example.marketback.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MarketFoodImg {

    @Id
    private String id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Market store;

    private String imgUrl;
}

package org.example.marketback.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Market extends AuditingFields {

    private String name;
    private String phoneNumber;
    private String address;
    private String openTime;
    private String marketImg;

    @OneToOne(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private MarketFoodImg foodMenuImg;

    @OneToOne(mappedBy = "market", cascade = CascadeType.ALL, orphanRemoval = true)
    private History history;

    @Builder.Default
    @OneToMany(mappedBy = "market", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tmi> tmiList = new ArrayList<>();

}

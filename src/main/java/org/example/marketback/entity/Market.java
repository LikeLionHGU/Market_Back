package org.example.marketback.entity;
import jakarta.persistence.*;
import lombok.*;
import org.example.marketback.entity.enums.Category;
import org.example.marketback.entity.enums.MarketCategory;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Market extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phoneNumber;
    private String address;
    private String openTime;
    private String marketImg;
    private String marketLogo;
    private String foodMenuImg;
    private String info; // 공영주차장을 위한 것
    private String color;
    
    @Enumerated(EnumType.STRING) // <-- 이 어노테이션을 추가하세요!
    private MarketCategory category;  // todo: add category enum

    @OneToOne(mappedBy = "market", cascade = CascadeType.ALL, orphanRemoval = true)
    private History history;

    @Builder.Default
    @OneToMany(mappedBy = "market", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tmi> tmiList = new ArrayList<>();

}

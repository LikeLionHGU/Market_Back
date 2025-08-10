package org.example.marketback.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tmi extends AuditingFields {

    private String title;
    @Column(length = 200)
    private String content;
    private Enum category;  // todo: add category enum
    private String email; // todo: email 보내는 건 나중에 해도 됨. (우선순위 낮아.) -> 제일 마지막
    private Long likes;
    private Long views;
    
    @ManyToOne
    @JoinColumn(name = "market_id")
    private Market market;
}

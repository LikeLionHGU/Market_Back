package org.example.marketback.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long historyId;

    private String content;

    private int countLike=0;

    private long viewCount=0;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "market_id")
    private Market market;

    public void plusLike() {
        this.countLike += 1;
    }

    public void minusLike() {
        this.countLike -= 1;
    }

    public void plusViewCount() {
        this.viewCount += 1;
    }
}

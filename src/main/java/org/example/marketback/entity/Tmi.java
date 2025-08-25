package org.example.marketback.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.marketback.entity.enums.Category;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tmi extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(length = 400)
    private String content;
    @Enumerated(EnumType.STRING) // <-- 이 어노테이션을 추가하세요!
    private Category category;  // todo: add category enum
    private String email; // todo: email 보내는 건 나중에 해도 됨. (우선순위 낮아.) -> 제일 마지막
    private Long likes;
    private Long views;

    @ManyToOne
    @JoinColumn(name = "market_id")
    private Market market;

    @Builder.Default
    @OneToMany(mappedBy = "tmi", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TmiComment> tmiCommentList = new ArrayList<>();

    // 조회수 증가 메소드 추가
    public void increaseViewCount() {
        this.views++;
    }

    public void increaseLikeCount() {
        this.likes++;
    }
}

package org.example.marketback.dto;

import lombok.*;
import org.example.marketback.entity.Tmi;
import org.example.marketback.entity.enums.Category;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TmiDto {

    private Long tmiId;
    private String title;
    private String content;
    private Category category;
    private String email;
    private Long likes;
    private Long views;
    private Long marketId;
    private String marketName;
    private List<TmiCommentDto> tmiCommentList;

    /**
     * Tmi 엔티티를 TmiDto로 변환하는 정적 팩토리 메서드
     * @param tmi 변환할 Tmi 엔티티 객체
     * @return 변환된 TmiDto 객체
     */
    public static TmiDto of(Tmi tmi) {
        // TmiComment 리스트를 TmiCommentDto 리스트로 변환
        List<TmiCommentDto> commentDtos = tmi.getTmiCommentList().stream()
                .map(TmiCommentDto::of)
                .collect(Collectors.toList());

        return TmiDto.builder()
                .tmiId(tmi.getId())
                .title(tmi.getTitle())
                .content(tmi.getContent())
                .category(tmi.getCategory())
                .email(tmi.getEmail())
                .likes(tmi.getLikes())
                .views(tmi.getViews())
                // Market 엔티티에서 ID와 이름 추출
                .marketId(tmi.getMarket().getId())
                .marketName(tmi.getMarket().getName())
                // 변환된 TmiCommentDto 리스트를 설정
                .tmiCommentList(commentDtos)
                .build();
    }
}
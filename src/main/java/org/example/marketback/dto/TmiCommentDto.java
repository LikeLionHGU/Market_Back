package org.example.marketback.dto;

import lombok.Builder;
import lombok.Getter;
import org.example.marketback.entity.TmiComment;

import java.time.LocalDateTime;

@Getter
@Builder
public class TmiCommentDto {
    private Long id;
    private String content;
    private LocalDateTime createdDate;

    public static TmiCommentDto of(TmiComment comment) {
        return TmiCommentDto.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .createdDate(comment.getCreatedDate())
                .build();
    }
}
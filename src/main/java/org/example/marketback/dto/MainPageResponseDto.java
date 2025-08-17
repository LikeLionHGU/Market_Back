package org.example.marketback.dto;

import lombok.Builder;
import lombok.Getter;
import org.example.marketback.entity.Tmi;

import java.util.List;

@Getter
@Builder
public class MainPageResponseDto {

    private List<PostInfo> topLikedPosts; // 좋아요 Top 2
    private List<PostInfo> topViewedPosts; // 조회수 Top 2
    private List<PostInfo> latestPosts;    // 최신글 Top 2

    // 각 게시물의 간단한 정보를 담을 내부 클래스
    @Getter
    @Builder
    public static class PostInfo {
        private Long tmiId;
        private String title;
        private String marketName;

        // Tmi 엔티티를 PostInfo DTO로 변환하는 정적 팩토리 메소드
        public static PostInfo from(Tmi tmi) {
            return PostInfo.builder()
                    .tmiId(tmi.getId())
                    .title(tmi.getTitle())
                    .marketName(tmi.getMarket().getName())
                    .build();
        }
    }
}
package org.example.marketback.controller;

import lombok.RequiredArgsConstructor;
import org.example.marketback.dto.MainPageResponseDto;
import org.example.marketback.service.MainPageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/main")
public class MainPageController {

    private final MainPageService mainPageService;

    // DB 상에서 있는 좋아요 1등~2등, 조회수 1등~2등, 최신글 1등~2등을 가져오는 API
    @GetMapping("/tops")
    public ResponseEntity<MainPageResponseDto> getTopPosts() {
        MainPageResponseDto topPosts = mainPageService.getTopPosts();
        return ResponseEntity.ok(topPosts);
    }
}
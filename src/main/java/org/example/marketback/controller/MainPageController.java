package org.example.marketback.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.marketback.dto.MainPageResponseDto;
import org.example.marketback.service.MainPageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "메인페이지", description = "메인페이지 관련 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/main")
public class MainPageController {

    private final MainPageService mainPageService;

    @Operation(summary = "인기 게시글 조회", description = "메인페이지에 표시할 인기 게시글들을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 조회됨"),
            @ApiResponse(responseCode = "500", description = "서버 내부 오류")
    })
    @GetMapping("/tops")
    public ResponseEntity<MainPageResponseDto> getTopPosts() {
        MainPageResponseDto topPosts = mainPageService.getTopPosts();
        return ResponseEntity.ok(topPosts);
    }
}
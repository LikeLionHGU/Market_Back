package org.example.marketback.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.marketback.controller.request.TmiCommentCreateRequest;
import org.example.marketback.dto.TmiCommentDto;
import org.example.marketback.entity.TmiComment;
import org.example.marketback.service.TmiCommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "TMI 댓글", description = "TMI 댓글 관련 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/tmi/{tmiId}/comments")
public class TmiCommentController {

    private final TmiCommentService tmiCommentService;

    @Operation(summary = "TMI 댓글 작성", description = "특정 TMI에 댓글을 작성합니다")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "댓글이 성공적으로 작성됨"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 데이터"),
            @ApiResponse(responseCode = "404", description = "해당 ID의 TMI를 찾을 수 없음"),
            @ApiResponse(responseCode = "500", description = "서버 내부 오류")
    })
    @PostMapping
    public ResponseEntity<TmiCommentDto> createComment(
            @Parameter(description = "TMI ID", required = true) @PathVariable Long tmiId,
            @Parameter(description = "댓글 작성 요청 데이터", required = true) @Valid @RequestBody TmiCommentCreateRequest request) {

        TmiComment createdComment = tmiCommentService.createComment(tmiId, request);
        TmiCommentDto responseDto = TmiCommentDto.of(createdComment);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }
}
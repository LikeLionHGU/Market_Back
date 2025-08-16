package org.example.marketback.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.marketback.controller.request.TmiCommentCreateRequest;
import org.example.marketback.dto.TmiCommentDto;
import org.example.marketback.entity.TmiComment;
import org.example.marketback.service.TmiCommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tmi/{tmiId}/comments") // 어떤 TMI에 대한 댓글인지 명시
public class TmiCommentController {

    private final TmiCommentService tmiCommentService;

    @PostMapping
    public ResponseEntity<TmiCommentDto> createComment(
            @PathVariable Long tmiId,
            @Valid @RequestBody TmiCommentCreateRequest request) {

        TmiComment createdComment = tmiCommentService.createComment(tmiId, request);
        TmiCommentDto responseDto = TmiCommentDto.of(createdComment);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }
}
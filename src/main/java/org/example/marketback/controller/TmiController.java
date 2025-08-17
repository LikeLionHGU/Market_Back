package org.example.marketback.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.marketback.controller.request.TmiCreateRequest;
import org.example.marketback.dto.TmiDto;
import org.example.marketback.entity.Tmi;
import org.example.marketback.service.TmiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tmi")
public class TmiController {

    private final TmiService tmiService;

    // Tmi 작성 api
    @PostMapping("/records")
    public ResponseEntity<TmiDto> recordTmi(
            @Valid @RequestBody TmiCreateRequest requestDto) {

        Tmi createdTmi = tmiService.createTmi(requestDto);
        TmiDto responseDto = TmiDto.of(createdTmi);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    // Tmi 상세 조회 api
    @GetMapping("/records/{tmiId}")
    public ResponseEntity<TmiDto> getTmiRecord(
            @PathVariable Long tmiId){

        // 서비스로부터 바로 DTO를 받음
        TmiDto responseDto = tmiService.getTmiById(tmiId);

        return ResponseEntity.ok(responseDto);
    }

    // 좋아요 api
    @PostMapping("/{tmiId}/like")
    public ResponseEntity<TmiDto> likeTmi(@PathVariable Long tmiId) {
        // 서비스로부터 바로 DTO를 받음
        TmiDto responseDto = tmiService.likeTmi(tmiId);
        return ResponseEntity.ok(responseDto);
    }
}
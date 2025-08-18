package org.example.marketback.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.marketback.controller.request.TmiCreateRequest;
import org.example.marketback.dto.TmiDto;
import org.example.marketback.entity.Tmi;
import org.example.marketback.service.TmiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "TMI", description = "TMI 게시글 관련 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/tmi")
public class TmiController {

    private final TmiService tmiService;

    @Operation(summary = "TMI 작성", description = "새로운 TMI 게시글을 작성합니다")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "TMI가 성공적으로 작성됨"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 데이터"),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 마켓 ID"),
            @ApiResponse(responseCode = "500", description = "서버 내부 오류")
    })
    @PostMapping("/records")
    public ResponseEntity<TmiDto> recordTmi(
            @Parameter(description = "TMI 작성 요청 데이터", required = true) @Valid @RequestBody TmiCreateRequest requestDto) {

        Tmi createdTmi = tmiService.createTmi(requestDto);
        TmiDto responseDto = TmiDto.of(createdTmi);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @Operation(summary = "TMI 상세 조회", description = "특정 TMI의 상세 정보를 조회합니다")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 조회됨"),
            @ApiResponse(responseCode = "404", description = "해당 ID의 TMI를 찾을 수 없음"),
            @ApiResponse(responseCode = "500", description = "서버 내부 오류")
    })
    @GetMapping("/records/{tmiId}")
    public ResponseEntity<TmiDto> getTmiRecord(
            @Parameter(description = "TMI ID", required = true) @PathVariable Long tmiId){

        // 서비스로부터 바로 DTO를 받음
        TmiDto responseDto = tmiService.getTmiById(tmiId);

        return ResponseEntity.ok(responseDto);
    }

    @Operation(summary = "TMI 좋아요", description = "특정 TMI에 좋아요를 추가합니다")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "좋아요가 성공적으로 처리됨"),
            @ApiResponse(responseCode = "404", description = "해당 ID의 TMI를 찾을 수 없음"),
            @ApiResponse(responseCode = "500", description = "서버 내부 오류")
    })
    @PostMapping("/{tmiId}/like")
    public ResponseEntity<TmiDto> likeTmi(
            @Parameter(description = "TMI ID", required = true) @PathVariable Long tmiId) {
        // 서비스로부터 바로 DTO를 받음
        TmiDto responseDto = tmiService.likeTmi(tmiId);
        return ResponseEntity.ok(responseDto);
    }
}
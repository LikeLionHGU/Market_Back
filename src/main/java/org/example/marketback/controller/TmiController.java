package org.example.marketback.controller;

import lombok.RequiredArgsConstructor;
import org.example.marketback.dto.TmiDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tmi")
public class TmiController {

    // Tmi 작성 api
    @PostMapping("/records")
    public ResponseEntity<TmiDto.TmiRecordResDto> recordTmi(
            @RequestBody TmiDto.TmiRecordReqDto tmiRecordReqDto) {
        return null;
    }

    // Tmi 상세 조회 api
    @GetMapping("/records/{tmiId}")
    public ResponseEntity<TmiDto.TmiRecordResDto> getTmiRecord(
            @PathVariable String tmiId){
        return null;
    }

}

package org.example.marketback.controller;

import lombok.RequiredArgsConstructor;
import org.example.marketback.dto.TMICreateRequest;
import org.example.marketback.dto.TMICurationDto;
import org.example.marketback.dto.TMIDto;
import org.example.marketback.service.TMIService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tmi")
@RequiredArgsConstructor
public class TMIController {
    
    private final TMIService tmiService;
    
    @GetMapping("/curated")
    public ResponseEntity<TMICurationDto> getCuratedTMI() {
        TMICurationDto curation = tmiService.getCuratedTMI();
        return ResponseEntity.ok(curation);
    }
    
    @PostMapping
    public ResponseEntity<TMIDto> createTMI(@RequestBody TMICreateRequest request) {
        TMIDto createdTMI = tmiService.createTMI(request);
        return ResponseEntity.ok(createdTMI);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TMIDto> getTMIDetail(@PathVariable Long id) {
        TMIDto tmiDetail = tmiService.getTMIDetail(id);
        return ResponseEntity.ok(tmiDetail);
    }
}
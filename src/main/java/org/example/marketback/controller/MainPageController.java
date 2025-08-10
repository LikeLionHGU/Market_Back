package org.example.marketback.controller;

import lombok.RequiredArgsConstructor;
import org.example.marketback.dto.MainPageDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/main")  // yml에 기본적으로 /api 붙여주니까, 참고해서 작업해
public class MainPageController {

     // DB 상에서 있는 좋아요 1등~2등, 최신글 1등~2등, 조회수 3등~4등, 최신글 1등~2등을 가져오는 API
     @GetMapping("/tops")
     public ResponseEntity<MainPageDto.MainTopReqDto> getTopPosts() {
         return null;
     }
}

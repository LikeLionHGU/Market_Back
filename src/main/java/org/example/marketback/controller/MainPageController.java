package org.example.marketback.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/main")  // yml에 기본적으로 /api 붙여주니까, 참고해서 작업해
public class MainPageController {
}

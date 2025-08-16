package org.example.marketback.controller.response;


import lombok.*;
import org.example.marketback.dto.TmiDto;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class TmiResponse {
    private Long id;
    private String title;
    private String content;
    private String category;
    private String email;
    private Long likes;
    private Long views;
    private String marketName;


}
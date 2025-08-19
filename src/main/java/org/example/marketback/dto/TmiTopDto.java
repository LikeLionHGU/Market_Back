package org.example.marketback.dto;

import lombok.Getter;
import org.example.marketback.entity.Tmi;

@Getter
public class TmiTopDto {
    private Long tmiId;
    private String title;
    private String content;

    public TmiTopDto(Tmi tmi) {
        this.tmiId = tmi.getId();
        this.title = tmi.getTitle();
        this.content = tmi.getContent();
    }
}
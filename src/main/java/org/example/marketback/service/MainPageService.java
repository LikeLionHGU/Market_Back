package org.example.marketback.service;

import lombok.RequiredArgsConstructor;
import org.example.marketback.dto.MainPageResponseDto;
import org.example.marketback.repository.TmiRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MainPageService {

    private final TmiRepository tmiRepository;

    public MainPageResponseDto getTopPosts() {
        // 1. 각 조건에 맞는 Top 2 TMI 엔티티 리스트를 조회합니다.
        List<MainPageResponseDto.PostInfo> topLiked = tmiRepository.findTop2ByOrderByLikesDesc()
                .stream()
                .map(MainPageResponseDto.PostInfo::from)
                .collect(Collectors.toList());

        List<MainPageResponseDto.PostInfo> topViewed = tmiRepository.findTop2ByOrderByViewsDesc()
                .stream()
                .map(MainPageResponseDto.PostInfo::from)
                .collect(Collectors.toList());

        List<MainPageResponseDto.PostInfo> latest = tmiRepository.findTop2ByOrderByCreatedDateDesc()
                .stream()
                .map(MainPageResponseDto.PostInfo::from)
                .collect(Collectors.toList());

        // 2. 조회된 리스트들을 DTO에 담아 반환합니다.
        return MainPageResponseDto.builder()
                .topLikedPosts(topLiked)
                .topViewedPosts(topViewed)
                .latestPosts(latest)
                .build();
    }
}
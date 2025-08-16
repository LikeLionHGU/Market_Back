package org.example.marketback.service;

import lombok.RequiredArgsConstructor;
import org.example.marketback.controller.request.TmiCommentCreateRequest;
import org.example.marketback.entity.Tmi;
import org.example.marketback.entity.TmiComment;
import org.example.marketback.repository.TmiCommentRepository;
import org.example.marketback.exception.TmiNotFoundException;
import org.example.marketback.repository.TmiRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TmiCommentService {

    private final TmiCommentRepository tmiCommentRepository;
    private final TmiRepository tmiRepository; // Tmi를 찾기 위해 필요

    @Transactional
    public TmiComment createComment(Long tmiId, TmiCommentCreateRequest req) {
        // 댓글을 달 부모 TMI를 찾습니다.
        Tmi tmi = tmiRepository.findById(tmiId)
                .orElseThrow(TmiNotFoundException::new); // TmiNotFoundException 재사용

        TmiComment newComment = TmiComment.builder()
                .content(req.getContent())
                .tmi(tmi) // 부모 TMI 설정
                .build();

        return tmiCommentRepository.save(newComment);
    }
}

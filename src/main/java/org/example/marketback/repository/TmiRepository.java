package org.example.marketback.repository;

import org.example.marketback.entity.Market;
import org.example.marketback.entity.Tmi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime; // import 추가
import java.util.List;
import java.util.Optional;

@Repository
public interface TmiRepository extends JpaRepository<Tmi, Long> {

    List<Tmi> findAllByMarket(Market market);
    List<Tmi> findTop3ByMarketOrderByLikesDesc(Market market);
    Optional<Tmi> findTopByMarketOrderByLikesDesc(Market market);
    List<Tmi> findTop2ByOrderByLikesDesc();
    List<Tmi> findTop2ByOrderByViewsDesc();
    List<Tmi> findTop2ByOrderByCreatedDateDesc();

    // --- 히스토리 업데이트를 위한 쿼리 메소드 추가 ---
    // 특정 마켓에 대해, 어제 하루 동안 작성된 모든 TMI를 조회
    List<Tmi> findAllByMarketAndCreatedDateBetween(Market market, LocalDateTime start, LocalDateTime end);
}
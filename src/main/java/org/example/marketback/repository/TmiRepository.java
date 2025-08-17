package org.example.marketback.repository;

import org.example.marketback.entity.Market;
import org.example.marketback.entity.Tmi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TmiRepository extends JpaRepository<Tmi, Long> {

    // Market 객체로 해당 마켓의 모든 TMI를 찾는 메소드
    List<Tmi> findAllByMarket(Market market);

    // 특정 마켓에서 좋아요가 가장 많은 TMI 3개를 찾는 메소드
    List<Tmi> findTop3ByMarketOrderByLikesDesc(Market market);

    // 특정 마켓에서 좋아요가 가장 많은 TMI 1개를 찾는 메소드
    Optional<Tmi> findTopByMarketOrderByLikesDesc(Market market);
}
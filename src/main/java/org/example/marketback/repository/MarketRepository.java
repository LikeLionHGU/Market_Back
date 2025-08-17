package org.example.marketback.repository;

import org.example.marketback.entity.Market;
import org.example.marketback.entity.enums.MarketCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MarketRepository extends JpaRepository<Market, Long> {
    Optional<Market> findByName(String marketName);

    // 이웃 가게 조회를 위한 메소드 추가
    List<Market> findByCategoryAndIdNot(MarketCategory category, Long id);
}
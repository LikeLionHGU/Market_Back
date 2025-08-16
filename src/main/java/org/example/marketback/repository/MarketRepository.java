package org.example.marketback.repository;

import org.example.marketback.entity.Market;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
// JpaRepository<Market, String> -> JpaRepository<Market, Long> 으로 수정
public interface MarketRepository extends JpaRepository<Market, Long> {
    Optional<Market> findByName(String marketName);

    // JpaRepository<Market, Long>으로 수정하면 아래 코드는 불필요하므로 삭제합니다.
    // Optional<Market> findById(Long id);
}
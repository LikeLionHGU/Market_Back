package org.example.marketback.repository;

import org.example.marketback.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {
    
    // Get most recent TMI entries
    List<History> findTop2ByOrderByHistoryIdDesc();
    
    // Get top viewed TMI entries
    List<History> findTop2ByOrderByViewCountDesc();
    
    // Get TMI entries by market
    List<History> findByMarketIdOrderByHistoryIdDesc(Long marketId);
}
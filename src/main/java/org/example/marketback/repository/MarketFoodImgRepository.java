package org.example.marketback.repository;

import org.example.marketback.entity.MarketFoodImg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketFoodImgRepository extends JpaRepository<MarketFoodImg, String> {
}

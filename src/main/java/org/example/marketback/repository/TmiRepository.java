package org.example.marketback.repository;

import org.example.marketback.entity.Tmi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
// JpaRepository<Tmi, String> -> JpaRepository<Tmi, Long> 으로 수정
public interface TmiRepository extends JpaRepository<Tmi, Long> {
    // JpaRepository<Tmi, Long>으로 수정하면 아래 코드는 불필요하므로 삭제합니다.
    // Optional<Tmi> findById(Long id);
}
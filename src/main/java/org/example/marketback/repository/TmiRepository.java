package org.example.marketback.repository;

import org.example.marketback.entity.Tmi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TmiRepository extends JpaRepository<Tmi, String> {
}

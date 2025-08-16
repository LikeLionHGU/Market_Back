package org.example.marketback.repository;

import org.example.marketback.entity.TmiComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TmiCommentRepository extends JpaRepository<TmiComment, Long> {
}
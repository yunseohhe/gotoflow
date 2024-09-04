package com.sparta.boardflow.repository;

import com.sparta.boardflow.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}

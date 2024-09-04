package com.sparta.boardflow.repository;

import com.sparta.boardflow.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}

package com.sparta.boardflow.repository;

import com.sparta.boardflow.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

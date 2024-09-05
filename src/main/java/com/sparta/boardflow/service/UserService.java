package com.sparta.boardflow.service;

import com.sparta.boardflow.config.JwtUtil;
import com.sparta.boardflow.dto.user.request.UserSaveRequestDto;
import com.sparta.boardflow.entity.User;
import com.sparta.boardflow.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    @Transactional
    public String createUser(UserSaveRequestDto userSaveRequestDto) {

        User newUser = new User(userSaveRequestDto.getName());
        User savedUser = userRepository.save(newUser);

        return jwtUtil.createToken(savedUser.getId());
    }
}

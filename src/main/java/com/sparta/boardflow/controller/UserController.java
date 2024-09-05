package com.sparta.boardflow.controller;

import com.sparta.boardflow.dto.user.reponse.UserSaveResponseDto;
import com.sparta.boardflow.dto.user.request.UserSaveRequestDto;
import com.sparta.boardflow.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    // 유저 추가
    @PostMapping("/users")
    public ResponseEntity<UserSaveResponseDto> createUser(@RequestBody UserSaveRequestDto userSaveRequestDto) {
        String bearerToken = userService.createUser(userSaveRequestDto);
        return ResponseEntity
                .ok()
                .header("Authorization", bearerToken)
                .build();
    }
}

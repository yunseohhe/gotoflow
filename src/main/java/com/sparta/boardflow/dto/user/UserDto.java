package com.sparta.boardflow.dto.user;

import lombok.Getter;

@Getter
public class UserDto {

    private final Long id;
    private final String userName;

    public UserDto(Long id, String userName) {
        this.id = id;
        this.userName = userName;
    }
}

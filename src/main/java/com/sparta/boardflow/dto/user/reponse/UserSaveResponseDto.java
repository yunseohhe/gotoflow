package com.sparta.boardflow.dto.user.reponse;

import lombok.Getter;

@Getter
public class UserSaveResponseDto {

    private final Long id;
    private final String name;

    public UserSaveResponseDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}

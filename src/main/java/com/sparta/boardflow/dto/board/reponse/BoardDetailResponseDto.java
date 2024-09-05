package com.sparta.boardflow.dto.board.reponse;

import com.sparta.boardflow.dto.user.UserDto;
import lombok.Getter;

@Getter
public class BoardDetailResponseDto {

    private final Long id;
    private final String detail;
    private final UserDto user;

    public BoardDetailResponseDto(Long id, String detail, UserDto user) {
        this.id = id;
        this.detail = detail;
        this.user = user;
    }
}

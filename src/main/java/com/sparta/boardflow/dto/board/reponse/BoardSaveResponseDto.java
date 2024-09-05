package com.sparta.boardflow.dto.board.reponse;

import com.sparta.boardflow.dto.user.UserDto;
import lombok.Getter;

@Getter
public class BoardSaveResponseDto {

    private final Long id;
    private final String title;
    private final String contents;
    private final UserDto user;

    public BoardSaveResponseDto(Long id, String title, String contents, UserDto user) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.user = user;
    }
}

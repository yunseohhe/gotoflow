package com.sparta.boardflow.dto.board.reponse;

import lombok.Getter;

@Getter
public class BoardSimpleResponseDto {

    private final String title;

    public BoardSimpleResponseDto(String title) {
        this.title = title;
    }
}

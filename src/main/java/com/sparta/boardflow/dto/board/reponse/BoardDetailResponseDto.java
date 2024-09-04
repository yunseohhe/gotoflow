package com.sparta.boardflow.dto.board.reponse;

import lombok.Getter;

@Getter
public class BoardDetailResponseDto {

    private final Long id;
    private final String title;
    private final String contents;

    public BoardDetailResponseDto(Long id, String title, String contents) {
        this.id = id;
        this.title = title;
        this.contents = contents;
    }
}

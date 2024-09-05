package com.sparta.boardflow.dto.comment.reponse;

import lombok.Getter;

@Getter
public class CommentSimpleResponseDto {

    private final Long id;
    private final String contents;

    public CommentSimpleResponseDto(Long id, String contents) {
        this.id = id;
        this.contents = contents;
    }
}

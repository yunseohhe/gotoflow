package com.sparta.boardflow.dto.comment.request;

import lombok.Getter;

@Getter
public class CommentSaveRequestDto {

    private Long boardId;
    private String contents;

}

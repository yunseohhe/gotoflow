package com.sparta.boardflow.controller;

import com.sparta.boardflow.dto.AuthUser;
import com.sparta.boardflow.dto.comment.reponse.CommentSimpleResponseDto;
import com.sparta.boardflow.dto.comment.reponse.CommentSaveResponseDto;
import com.sparta.boardflow.dto.comment.request.CommentSaveRequestDto;
import com.sparta.boardflow.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    // 댓글 추가
    @PostMapping("/boards/{boardId}/comments")
    public ResponseEntity<CommentSaveResponseDto> saveComment(AuthUser authUser, @RequestBody CommentSaveRequestDto commentSaveRequestDto) {
        Long userId = authUser.getId();
        return ResponseEntity.ok(commentService.saveComment(userId, commentSaveRequestDto));
    }

    // 댓글 전체 조회
    @GetMapping("/boards/comments")
    public ResponseEntity<List<CommentSimpleResponseDto>> getComments() {
        return ResponseEntity.ok(commentService.getComments());
    }
}

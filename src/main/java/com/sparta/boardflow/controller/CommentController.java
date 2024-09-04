package com.sparta.boardflow.controller;

import com.sparta.boardflow.dto.comment.reponse.CommentResponseDto;
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
    public ResponseEntity<CommentSaveResponseDto> saveComment(@PathVariable("boardId") Long boardId, @RequestBody CommentSaveRequestDto commentSaveRequestDto) {
        return ResponseEntity.ok(commentService.saveComment(boardId, commentSaveRequestDto));
    }

    // 댓글 전체 조회
    @GetMapping("/boards/comments")
    public ResponseEntity<List<CommentResponseDto>> getComments() {
        return ResponseEntity.ok(commentService.getComments());
    }
}

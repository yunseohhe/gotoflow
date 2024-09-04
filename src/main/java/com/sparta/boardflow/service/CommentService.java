package com.sparta.boardflow.service;

import com.sparta.boardflow.dto.comment.reponse.CommentResponseDto;
import com.sparta.boardflow.dto.comment.reponse.CommentSaveResponseDto;
import com.sparta.boardflow.dto.comment.request.CommentSaveRequestDto;
import com.sparta.boardflow.entity.Board;
import com.sparta.boardflow.entity.Comment;
import com.sparta.boardflow.repository.BoardRepository;
import com.sparta.boardflow.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public CommentSaveResponseDto saveComment(Long boardId, CommentSaveRequestDto commentSaveRequestDto) {

        Board board = boardRepository.findById(boardId).orElseThrow(() -> new NullPointerException("해당하는 보드가 없습니다."));

        Comment newComment = new Comment(commentSaveRequestDto.getContents(), board);
        Comment savedComment = commentRepository.save(newComment);

        return new CommentSaveResponseDto(savedComment.getId(), savedComment.getContents());
    }

    public List<CommentResponseDto> getComments() {
        List<Comment> commentList = commentRepository.findAll();

        List<CommentResponseDto> dtoList = new ArrayList<>();
        for (Comment comment : commentList) {
            dtoList.add(new CommentResponseDto(comment.getId(), comment.getContents()));
        }
        return dtoList;
    }
}

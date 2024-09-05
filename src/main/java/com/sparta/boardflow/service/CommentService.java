package com.sparta.boardflow.service;

import com.sparta.boardflow.dto.comment.reponse.CommentSimpleResponseDto;
import com.sparta.boardflow.dto.comment.reponse.CommentSaveResponseDto;
import com.sparta.boardflow.dto.comment.request.CommentSaveRequestDto;
import com.sparta.boardflow.entity.Board;
import com.sparta.boardflow.entity.Comment;
import com.sparta.boardflow.entity.User;
import com.sparta.boardflow.repository.BoardRepository;
import com.sparta.boardflow.repository.CommentRepository;
import com.sparta.boardflow.repository.UserRepository;
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
    private final UserRepository userRepository;

    @Transactional
    public CommentSaveResponseDto saveComment(Long userdId, CommentSaveRequestDto commentSaveRequestDto) {
        User user = userRepository.findById(userdId)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다."));

        Board board = boardRepository.findById(commentSaveRequestDto.getBoardId())
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));

        Comment newComment = new Comment(board, commentSaveRequestDto.getContents(), user);
        Comment savedComment = commentRepository.save(newComment);

        return new CommentSaveResponseDto(savedComment.getId(), savedComment.getContests());
    }

    public List<CommentSimpleResponseDto> getComments() {
        List<Comment> commentList = commentRepository.findAll();

        List<CommentSimpleResponseDto> dtoList = new ArrayList<>();
        for (Comment comment : commentList) {
            dtoList.add(new CommentSimpleResponseDto(comment.getId(), comment.getContests()));
        }
        return dtoList;
    }
}

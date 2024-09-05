package com.sparta.boardflow.controller;

import com.sparta.boardflow.dto.AuthUser;
import com.sparta.boardflow.dto.board.reponse.BoardDetailResponseDto;
import com.sparta.boardflow.dto.board.reponse.BoardSaveResponseDto;
import com.sparta.boardflow.dto.board.reponse.BoardSimpleResponseDto;
import com.sparta.boardflow.dto.board.reponse.BoardUpdateResponseDto;
import com.sparta.boardflow.dto.board.request.BoardSaveRequestDto;
import com.sparta.boardflow.dto.board.request.BoardUpdateRequestDto;
import com.sparta.boardflow.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;


    // 추가
    @PostMapping("/boards")
    public ResponseEntity<BoardSaveResponseDto> saveBoards(AuthUser authUser, @RequestBody BoardSaveRequestDto boardSaveRequestDto) {
        Long userId = authUser.getId();
        return ResponseEntity.ok(boardService.saveBoards(userId, boardSaveRequestDto));
    }

    // 단건 조회
    @GetMapping("/boards/{boardId}")
    public ResponseEntity<BoardDetailResponseDto> getBoard(@PathVariable("boardId") Long boardId) {
        return ResponseEntity.ok(boardService.getBoard(boardId));
    }

    // 전체 조회
    @GetMapping("/boards")
    public ResponseEntity<List<BoardSimpleResponseDto>> getBoards() {
        return ResponseEntity.ok(boardService.getBoards());
    }

    // 단건 수정
    @PutMapping("/boards/{boardId}")
    public ResponseEntity<BoardUpdateResponseDto> updateBoard(@PathVariable("boardId") Long boardId, @RequestBody BoardUpdateRequestDto boardUpdateRequestDto) {
        return ResponseEntity.ok(boardService.updateBoard(boardId, boardUpdateRequestDto));
    }

    // 삭제
    @DeleteMapping("/boards/{boardId}")
    public ResponseEntity<Void> deleteBoard(@PathVariable("boardId") Long boardId) {
        boardService.deleteBoard(boardId);
       return ResponseEntity.ok().build();
    }
}

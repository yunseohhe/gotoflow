package com.sparta.boardflow.service;

import com.sparta.boardflow.dto.board.reponse.BoardSaveResponseDto;
import com.sparta.boardflow.dto.board.reponse.BoardDetailResponseDto;
import com.sparta.boardflow.dto.board.reponse.BoardSimpleResponseDto;
import com.sparta.boardflow.dto.board.reponse.BoardUpdateResponseDto;
import com.sparta.boardflow.dto.board.request.BoardSaveRequestDto;
import com.sparta.boardflow.dto.board.request.BoardUpdateRequestDto;
import com.sparta.boardflow.entity.Board;
import com.sparta.boardflow.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public BoardSaveResponseDto saveBoards(BoardSaveRequestDto boardSaveRequestDto) {
        Board newBoard = new Board(
                boardSaveRequestDto.getTitle(),
                boardSaveRequestDto.getContents()
        );
        Board savedBoard = boardRepository.save(newBoard);

        return new BoardSaveResponseDto(savedBoard.getId(), savedBoard.getTitle(), savedBoard.getContents());
    }

    public BoardDetailResponseDto getBoard(Long boardId) {
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new NullPointerException("해당하는 board가 없습니다."));

        return new BoardDetailResponseDto(board.getId(), board.getTitle(), board.getContents());
    }

    public List<BoardSimpleResponseDto> getBoards() {
        List<Board> boardList = boardRepository.findAll();

        List<BoardSimpleResponseDto> dtoList = new ArrayList<>();
        for (Board board : boardList) {
            BoardSimpleResponseDto dto = new BoardSimpleResponseDto(board.getTitle());
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Transactional
    public BoardUpdateResponseDto updateBoard(Long boardId, BoardUpdateRequestDto boardUpdateRequestDto) {
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new NullPointerException("해당하는 board가 없습니다."));

        board.update(boardUpdateRequestDto.getContents());

        return new BoardUpdateResponseDto(board.getId(), board.getTitle(), board.getTitle());
    }

    @Transactional
    public void deleteBoard(Long boardId) {
        if (!boardRepository.existsById(boardId)) {
            throw new NullPointerException("해당하는 board가 없습니다.");
        }

        boardRepository.deleteById(boardId);
    }
}

package com.woojin.boardback.service;

import org.springframework.http.ResponseEntity;

import com.woojin.boardback.dto.request.board.PostBoardRequestDto;
import com.woojin.boardback.dto.response.board.PostBoardResponseDto;

public interface BoardService {
    ResponseEntity<? super PostBoardResponseDto> postBoard(PostBoardRequestDto dto, String email);
}

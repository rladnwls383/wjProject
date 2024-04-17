package com.woojin.boardback.service;

import org.springframework.http.ResponseEntity;

import com.woojin.boardback.dto.response.board.IncreaseViewCountResponseDto;
import com.woojin.boardback.dto.response.board.GetCommentListResponseDto;
import com.woojin.boardback.dto.response.board.PostCommentResponseDto;
import com.woojin.boardback.dto.response.board.GetBoardResponseDto;
import com.woojin.boardback.dto.response.board.GetFavoriteListResponseDto;
import com.woojin.boardback.dto.request.board.PatchBoardRequestDto;
import com.woojin.boardback.dto.request.board.PostBoardRequestDto;
import com.woojin.boardback.dto.request.board.PostCommentRequestDto;
import com.woojin.boardback.dto.response.board.PostBoardResponseDto;
import com.woojin.boardback.dto.response.board.PutFavoriteResponseDto;
import com.woojin.boardback.dto.response.board.DeleteBoardResponseDto;
import com.woojin.boardback.dto.response.board.PatchBoardResponseDto;

public interface BoardService {
    ResponseEntity<? super GetBoardResponseDto> getBoard(Integer boardNumber);
    ResponseEntity<? super GetFavoriteListResponseDto> getFavoriteList(Integer boardNumber);
    ResponseEntity<? super GetCommentListResponseDto> getCommentList(Integer boardNumber);
    ResponseEntity <? super PostCommentResponseDto> postComment (PostCommentRequestDto dto, Integer boardNumber, String email);
    ResponseEntity<? super PostBoardResponseDto> postBoard(PostBoardRequestDto dto, String email);
    ResponseEntity<? super PutFavoriteResponseDto> putFavorite(Integer boardNumber, String email);
    ResponseEntity<? super IncreaseViewCountResponseDto> increaseViewCount(Integer boardNumber);
    ResponseEntity<? super DeleteBoardResponseDto> deleteBoard(Integer boardNumber, String email);
    ResponseEntity<? super PatchBoardResponseDto> patchBoard(PatchBoardRequestDto dto, Integer boardNumber, String email);
}

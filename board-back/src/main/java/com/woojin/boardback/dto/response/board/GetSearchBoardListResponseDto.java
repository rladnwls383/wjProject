package com.woojin.boardback.dto.response.board;

import com.woojin.boardback.common.ResponseCode;
import com.woojin.boardback.common.ResponseMessage;
import com.woojin.boardback.dto.object.BoardListItem;
import com.woojin.boardback.dto.response.ResponseDto;
import com.woojin.boardback.entity.BoardListViewEntity;

import lombok.Getter;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class GetSearchBoardListResponseDto extends ResponseDto {
    
    private List<BoardListItem> searchList;

    private GetSearchBoardListResponseDto(List<BoardListViewEntity> boardListViewEnties) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.searchList = BoardListItem.getList(boardListViewEnties);
    }

    public static ResponseEntity<GetSearchBoardListResponseDto> success(List<BoardListViewEntity> boardListViewEntities) {
        GetSearchBoardListResponseDto result = new GetSearchBoardListResponseDto(boardListViewEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}

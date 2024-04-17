package com.woojin.boardback.dto.response.board;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.woojin.boardback.common.ResponseCode;
import com.woojin.boardback.common.ResponseMessage;
import com.woojin.boardback.dto.object.BoardListItem;
import com.woojin.boardback.dto.response.ResponseDto;
import com.woojin.boardback.entity.BoardListViewEntity;

import lombok.Getter;

@Getter
public class GetLatestBoardListResponseDto extends ResponseDto {
    
    private List<BoardListItem> latestList;

    private GetLatestBoardListResponseDto(List<BoardListViewEntity> BoardEntities) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.latestList = BoardListItem.getList(BoardEntities);
    }

    public static ResponseEntity<GetLatestBoardListResponseDto> success(List<BoardListViewEntity> BoardEntities) {
        GetLatestBoardListResponseDto result = new GetLatestBoardListResponseDto(BoardEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}

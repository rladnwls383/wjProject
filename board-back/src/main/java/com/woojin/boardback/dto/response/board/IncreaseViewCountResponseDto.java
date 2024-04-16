package com.woojin.boardback.dto.response.board;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.woojin.boardback.common.ResponseCode;
import com.woojin.boardback.common.ResponseMessage;
import com.woojin.boardback.dto.response.ResponseDto;

public class IncreaseViewCountResponseDto extends ResponseDto {
    private IncreaseViewCountResponseDto() {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
    }
        
    public static ResponseEntity<IncreaseViewCountResponseDto> success() {
        IncreaseViewCountResponseDto result = new IncreaseViewCountResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> noExistsBoard() {
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_BOARD, ResponseMessage.NOT_EXISTED_USER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
}

package com.woojin.boardback.service.implement;

import org.springframework.http.ResponseEntity;

import com.woojin.boardback.dto.request.auth.SignInRequestDto;
import com.woojin.boardback.dto.request.auth.SignUpRequestDto;
import com.woojin.boardback.dto.response.auth.SignInResponseDto;
import com.woojin.boardback.dto.response.auth.SignUpResponseDto;

public interface AuthService {
    
    ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto);
    ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto);

}

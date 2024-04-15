package com.woojin.boardback.service;

import org.springframework.http.ResponseEntity;

import com.woojin.boardback.dto.response.user.GetSignInUserResponseDto;

public interface UserService {
    ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String email);
}

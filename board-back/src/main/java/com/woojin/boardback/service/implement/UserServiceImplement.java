package com.woojin.boardback.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.woojin.boardback.dto.response.ResponseDto;
import com.woojin.boardback.dto.response.user.GetSignInUserResponseDto;
import com.woojin.boardback.entity.UserEntity;
import com.woojin.boardback.repository.UserRespository;
import com.woojin.boardback.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImplement implements UserService {

    private final UserRespository userRespository;
    
    @Override
    public ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String email) {
       
        UserEntity userEntity = null;

        try {

            userEntity = userRespository.findByEmail(email);
            if (userEntity == null) return GetSignInUserResponseDto.notExistsUser();
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetSignInUserResponseDto.success(userEntity);

    }
    
}

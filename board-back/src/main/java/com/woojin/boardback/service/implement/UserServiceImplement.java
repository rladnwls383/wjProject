package com.woojin.boardback.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.woojin.boardback.dto.request.user.PatchNicknameRequestDto;
import com.woojin.boardback.dto.request.user.PatchProfileImageRequestDto;
import com.woojin.boardback.dto.response.ResponseDto;
import com.woojin.boardback.dto.response.user.GetSignInUserResponseDto;
import com.woojin.boardback.dto.response.user.GetUserResponseDto;
import com.woojin.boardback.dto.response.user.PatchNicknameResponseDto;
import com.woojin.boardback.dto.response.user.PatchProfileImageResponseDto;
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

    @Override
    public ResponseEntity<? super GetUserResponseDto> getUser(String email) {
        
        UserEntity userEntity = null;

        try {

            userEntity = userRespository.findByEmail(email);
            if (userEntity == null) return GetUserResponseDto.noExistUser();
            
        } catch (Exception exception) {
            exception.printStackTrace();
            ResponseDto.databaseError();
        }

        return GetUserResponseDto.success(userEntity);
    }

    @Override
    public ResponseEntity<? super PatchNicknameResponseDto> patchNickname(PatchNicknameRequestDto dto, String email) {
        try {
            
            UserEntity userEntity = userRespository.findByEmail(email);
            if (userEntity == null) PatchNicknameResponseDto.noExistUser();

            String nickname = dto.getNickname();
            boolean existedNickname = userRespository.existsByNickname(nickname);
            if (existedNickname) return PatchNicknameResponseDto.duplicateNickname();

            userEntity.setNickname(nickname);
            userRespository.save(userEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return PatchNicknameResponseDto.success();
    }

    @Override
    public ResponseEntity<? super PatchProfileImageResponseDto> patchProfileImage(PatchProfileImageRequestDto dto, String email) {
        
        try {

            UserEntity userEntity = userRespository.findByEmail(email);
            if (userEntity == null) return PatchProfileImageResponseDto.noExistUser();

            String profileImage = dto.getProfileImage();
            
            userEntity.setProfileImage(profileImage);
            userRespository.save(userEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return PatchProfileImageResponseDto.success();

    }
    
}

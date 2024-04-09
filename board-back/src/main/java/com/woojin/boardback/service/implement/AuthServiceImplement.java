package com.woojin.boardback.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.woojin.boardback.dto.request.auth.SignInRequestDto;
import com.woojin.boardback.dto.request.auth.SignUpRequestDto;
import com.woojin.boardback.dto.response.ResponseDto;
import com.woojin.boardback.dto.response.auth.SignInResponseDto;
import com.woojin.boardback.dto.response.auth.SignUpResponseDto;
import com.woojin.boardback.entity.UserEntity;
import com.woojin.boardback.provider.JwtProvider;
import com.woojin.boardback.repository.UserRespository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImplement implements AuthService {

    private final UserRespository userRespository;
    private final JwtProvider jwtProvider;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto) {
        
        try {

            String email = dto.getEmail();
            boolean existedEmail = userRespository.existsByEmail(email);
            if (existedEmail) return SignUpResponseDto.duplicateEmail();

            String nickname = dto.getNickname();
            boolean existsByNickname = userRespository.existsByNickname(nickname);
            if (existsByNickname) return SignUpResponseDto.duplicateNickname();

            String telNumber = dto.getTelNumber();
            Boolean existedTelNumber = userRespository.existsByTelNumber(telNumber);
            if (existedTelNumber) return SignUpResponseDto.duplicateTelNumber();

            // 패스워드 암호화
            String password = dto.getPassword();
            String encodedPassword = passwordEncoder.encode(password);
            dto.setPassword(encodedPassword);

            UserEntity userEntity = new UserEntity(dto);
            userRespository.save(userEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return SignUpResponseDto.success();

    }

    @Override
    public ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto) {
        
        String token = null;

        try {

            String email = dto.getEmail();
            UserEntity userEntity = userRespository.findByEmail(email);
            if (userEntity == null) return SignInResponseDto.signInFailed();

            String password = dto.getPassword();
            String encodedPassword = userEntity.getPassword();
            boolean isMatched = passwordEncoder.matches(password, encodedPassword);
            if (!isMatched) return SignInResponseDto.signInFailed();

            token = jwtProvider.create(email);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return SignInResponseDto.success(token);

    }
    
}

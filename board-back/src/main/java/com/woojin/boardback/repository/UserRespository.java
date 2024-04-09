package com.woojin.boardback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.woojin.boardback.entity.UserEntity;

@Repository
public interface UserRespository extends JpaRepository<UserEntity, String> {
    
    boolean existsByEmail(String email);
    boolean existsByNickname(String nickname);
    boolean existsByTelNumber(String telNumber);

    UserEntity findByEmail(String email);

}

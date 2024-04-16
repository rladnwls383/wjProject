package com.woojin.boardback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.woojin.boardback.entity.ImageEntity;

@Repository
public interface ImageRepository extends JpaRepository<ImageEntity, Integer> {
    
    List<ImageEntity> findByBoardNumber(Integer boardNumber);

    @Transactional
    void deleteByBoardNumber(Integer bordNumber);

}

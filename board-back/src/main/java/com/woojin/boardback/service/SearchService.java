package com.woojin.boardback.service;

import org.springframework.http.ResponseEntity;
import com.woojin.boardback.dto.response.search.GetPopularListResponseDto;

public interface SearchService {
    
    ResponseEntity<? super GetPopularListResponseDto> getPopularList();

}

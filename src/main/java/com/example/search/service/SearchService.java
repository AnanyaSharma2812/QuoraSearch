package com.example.search.service;

import com.example.search.entity.SearchEntity;
import org.springframework.data.domain.Page;

public interface SearchService {

    void consume(String message);
    Page<SearchEntity> search(int pageSize, int pageNumber, String keyword);

}

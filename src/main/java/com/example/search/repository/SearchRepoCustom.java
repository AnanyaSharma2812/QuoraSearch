package com.example.search.repository;

import com.example.search.entity.SearchEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;


public interface SearchRepoCustom
{
    public Page<SearchEntity> search(int pageSize, int pageNumber, String keyword);
}


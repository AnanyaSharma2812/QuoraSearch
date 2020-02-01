package com.example.search.repository;

import com.example.search.entity.SearchEntity;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchRepo extends SolrCrudRepository<SearchEntity,String> {


}

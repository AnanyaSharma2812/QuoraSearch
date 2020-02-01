package com.example.search.repository.SearchRepoImpl;

import com.example.search.entity.SearchEntity;
import com.example.search.repository.SearchRepoCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.stereotype.Repository;

@Repository
public class SearchRepoImpl implements SearchRepoCustom
{

    @Autowired
    private SolrTemplate solrTemplate;

    @Override
    public Page<SearchEntity> search(int pageSize, int pageNumber, String keyword)
    {
        Query query;
        query = new SimpleQuery(new Criteria("profileValue").boost(10).contains(keyword)
                    .or(new Criteria("questionValue").boost(10).contains(keyword))
                    .or(new Criteria("askerProfileName").boost(8).contains(keyword))
                    .or(new Criteria("categoryName").boost(10).contains(keyword))
                    .or(new Criteria("approvedAnswererProfile").boost(8).contains(keyword)));

        query.setPageRequest(PageRequest.of(pageNumber, pageSize));

        return solrTemplate.query("quoraCollection", query, SearchEntity.class);
    }


}

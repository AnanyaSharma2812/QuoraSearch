package com.example.search.service.serviceImpl;

import com.example.search.dto.SearchDto;
import com.example.search.entity.SearchEntity;
import com.example.search.repository.SearchRepo;
import com.example.search.repository.SearchRepoCustom;
import com.example.search.service.SearchService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SearchServiceImpl implements SearchService {
    static int i=0;

    @Autowired
    SearchRepo searchRepo;

    @Autowired
    SearchRepoCustom searchRepoCustom;


//        SearchDto searchDto=new SearchDto();


        @KafkaListener(topics="addToSearch",groupId="group-id")
        @Override
        public void consume(String message)
        {
            //SearchEntity searchEntity = new SearchEntity();
            ObjectMapper objectMapper = new ObjectMapper();
            SearchDto searchDto = new SearchDto();
            try
            {
                searchDto = objectMapper.readValue(message, SearchDto.class);
                System.out.println(searchDto.toString());
                SearchEntity searchEntity=new SearchEntity();
                BeanUtils.copyProperties(searchDto,searchEntity);
                i++;
                searchEntity.setSearchId(String.valueOf(i));
                searchRepo.save(searchEntity);
                System.out.println(searchDto.toString());
            }
            catch (Exception e)
            {
                //log.error("Error : ", e);
                System.out.println("Error : "+e);
            }
        }




        @Override
        public Page<SearchEntity> search(int pageSize, int pageNumber, String keyword)
        {
            return searchRepoCustom.search(pageSize,pageNumber,keyword);
        }

    }



package com.example.search.controller;

import com.example.search.entity.SearchEntity;
import com.example.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
    @RestController
    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @RequestMapping("/search")
    public class SearchController
    {

        @Autowired
        SearchService searchService;

//    @PostMapping("/addInSearch")
//    public ResponseEntity<String> addInSearch(@RequestBody SearchDTO searchDTO)
//    {
//        SearchEntity searchEntity=new SearchEntity();
//        BeanUtils.copyProperties(searchDTO,searchEntity);
//        SearchEntity searchDocCreated=searchServices.save(searchEntity);
//        return new ResponseEntity<String>(searchDocCreated.getProductId(),HttpStatus.CREATED);
//    }

        @GetMapping("/searchFunction")
        public ResponseEntity<Page<SearchEntity>> search(@RequestParam(defaultValue = "0") Integer pageNumber,
                                                         @RequestParam(defaultValue = "5") Integer pageSize,
                                                         @RequestParam("keyword") String keyword)
        {
            return new ResponseEntity<Page<SearchEntity>>(searchService.search(pageSize,pageNumber,keyword),HttpStatus.OK);
        }


    }



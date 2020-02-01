package com.example.search.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(collection = "quoraCollection")
@Getter
@Setter
public class SearchEntity
{

    @Indexed(name="profileValue",type="text")
    String profileValue;
    @Indexed(name="profileId",type="string")
    String profileId;
    @Indexed(name="profileType",type="string")
    String profileType;
    @Id
    @Indexed(name="searchId",type="string")
    String searchId;

    @Indexed(name="valueType",type="string")
    String valueType ;

    @Indexed(name="questionValue",type="text")
    String questionValue;
    @Indexed(name="questionId",type="string")
    String questionId;
    @Indexed(name="questionStatus",type="string")
    Boolean questionStatus;
    @Indexed(name="askerProfileId",type="string")
    String askerProfileId;
    @Indexed(name="askerProfleName",type="text")
    String askerProfileName;

    @Indexed(name="numberOfLikes",type="string")
    int numberOfLikes;

    @Indexed(name="numberOfDislikes",type="string")
    int numberOfDislikes;

    @Indexed(name="approvedAnswerId",type="string")
    String approvedAnswerId;
    @Indexed(name="approvedAnswer",type="text")
    String approvedAnswer;
    @Indexed(name="approvedAnswererId",type="string")
    String approvedAnswererId;
    @Indexed(name="approvedAnswererProfile",type="text")
    String approvedAnswererProfile;

    @Indexed(name="categoryId",type="string")
    String categoryId;
    @Indexed(name="categoryName",type="text")
    String categoryName;

}

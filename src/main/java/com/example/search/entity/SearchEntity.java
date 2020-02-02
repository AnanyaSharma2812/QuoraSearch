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
    private String profileValue="";
    @Indexed(name="profileId",type="string")
    private String profileId="";
    @Indexed(name="profileType",type="string")
    private String profileType="";
    @Id
    @Indexed(name="searchId",type="string")
    private String searchId="";

    @Indexed(name="valueType",type="string")
    private String valueType="";

    @Indexed(name="questionValue",type="text")
    private String questionValue="";
    @Indexed(name="questionId",type="string")
    private String questionId="";
    @Indexed(name="questionStatus",type="string")
    private Boolean questionStatus=false;
    @Indexed(name="askerProfileId",type="string")
    private String askerProfileId="";
    @Indexed(name="askerProfileName",type="text")
    private String askerProfileName="";

    @Indexed(name="numberOfLikes",type="string")
    private int numberOfLikes=0;

    @Indexed(name="numberOfDislikes",type="string")
    private int numberOfDislikes=0;

    @Indexed(name="approvedAnswerId",type="string")
    private String approvedAnswerId="";
    @Indexed(name="approvedAnswer",type="text")
    private String approvedAnswer="";
    @Indexed(name="approvedAnswererId",type="string")
    private String approvedAnswererId="";
    @Indexed(name="approvedAnswererProfile",type="text")
    private String approvedAnswererProfile="";

    @Indexed(name="categoryId",type="string")
    private String categoryId="";
    @Indexed(name="categoryName",type="text")
    private String categoryName="";

}

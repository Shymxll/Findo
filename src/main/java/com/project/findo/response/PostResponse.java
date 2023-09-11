package com.project.findo.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostResponse {

    private long id;
    private short worf;
    private String text;
    private String image;
    private String category;
    private String question;
    private String country;
    private String city;
    private String mapLocation;
    private Date createdDate;



}

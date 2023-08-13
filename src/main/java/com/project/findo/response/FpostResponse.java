package com.project.findo.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FpostResponse {
   
    private Long id;
    private String text;
    private String category;
    private String question;
    private String country;
    private String city;
    private String mapLocation;
    private String createdDate;
    private String updatedDate;


}

package com.project.forvi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostUpdateDto {
    
    long id;
    String text;
    String category;
    String country;
    String question;
    String answer;
    String image;
    String city;
    String mapLocation;
}

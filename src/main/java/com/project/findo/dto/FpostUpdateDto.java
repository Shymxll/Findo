package com.project.findo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FpostUpdateDto {
    
    long id;
    String text;
    String category;
    String country;
    String question;
    String answer;
    String city;
    String mapLocation;
}

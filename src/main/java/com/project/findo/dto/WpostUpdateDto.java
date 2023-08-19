package com.project.findo.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WpostUpdateDto {
    
    long id;
    String text;
    String category;
    String country;
    String question;
    String answer;
    String city;
    String mapLocation;
}

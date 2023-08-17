package com.project.findo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FpostCreateDto {
    
    Long userId;
    String text;
    String category;
    String country;
    String city;
    String question;
    String answer;
    String mapLocation;
}

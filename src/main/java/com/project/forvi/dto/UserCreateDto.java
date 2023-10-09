package com.project.forvi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDto {
    
    String name;
    String surname;
    String email;
    String phone;
    String password;
}

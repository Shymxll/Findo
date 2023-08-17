package com.project.findo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.findo.dto.UserCreateDto;
import com.project.findo.entity.User;
import com.project.findo.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private  PasswordEncoder passwordEncoder;
    
 

    

    public String addUser(UserCreateDto userCreateDto) {
        System.out.println(userCreateDto.toString());
        String hashPsw = passwordEncoder.encode(userCreateDto.getPassword());
        System.out.println(hashPsw);
        User user = User.builder()
                .email(userCreateDto.getEmail())
                .psw(hashPsw)
                .name(userCreateDto.getName())
                .role("user")
                .phone(userCreateDto.getPhone())
                .build();
        try {
            userRepository.save(user);
        } catch (Exception e) {
            return "Error";
        };
        return "Success";
    }

    

    
    
    

}

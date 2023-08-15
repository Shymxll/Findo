package com.project.findo.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.findo.dto.UserCreateDto;
import com.project.findo.entity.User;
import com.project.findo.repository.UserRepository;

@Service
public class UserService {
    
    private final UserRepository userRepository;
    
 

    public UserService(UserRepository userRepository) {
       
        this.userRepository = userRepository;
    }

    public User addUser(UserCreateDto userCreateDto) {
           
            
            return null;
    }

    

    
    
    

}

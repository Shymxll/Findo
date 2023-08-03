package com.project.findo.service;

import org.springframework.stereotype.Service;

import com.project.findo.repository.UserRepository;

@Service
public class UserService {
    
    private final UserRepository userRepository;
    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    

}

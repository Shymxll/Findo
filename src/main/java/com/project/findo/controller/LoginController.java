package com.project.findo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.findo.dto.UserCreateDto;
import com.project.findo.service.UserService;


@RestController
@RequestMapping("/api")
public class LoginController {
    
    private UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }
    /*
     * /login
     * /register
     */

    @PostMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/register")
    public String register(@RequestBody UserCreateDto userCreateDto) {
            return userService.addUser(userCreateDto);
    }
}

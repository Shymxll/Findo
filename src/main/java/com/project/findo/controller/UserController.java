package com.project.findo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.findo.dto.UserCreateDto;
import com.project.findo.dto.UserUpdateDto;
import com.project.findo.entity.User;
import com.project.findo.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;
    
    /**
     * API list for user
     * 
     *  /api/user/all -> get all user
     * /api/user/{id} -> get user by id
     * /api/user/add -> add user
     * /api/user/update -> update user
     * /api/user/delete -> delete user 
     */

    @GetMapping("/all")
    public String getAllUser(){
        return "All user";
    }

    @GetMapping("/{id}")
    public String getUserById(@RequestParam Long id){
        return "User by id";
    }

    @PostMapping("/add")
    public String addUser(@RequestBody UserCreateDto userCreateDto){
        return userService.addUser(userCreateDto);
    }

    @PostMapping("/update")
    public String updateUser(@RequestBody UserUpdateDto userUpdateDto){
        
        return "Update user";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam Long id){
        return "Delete user";
    }

    
    
}

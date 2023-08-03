package com.project.findo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.findo.dto.UserCreateDto;
import com.project.findo.dto.UserUpdateDto;

@RestController
@RequestMapping("/api/user")
public class UserController {
    
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
        return "Add user";
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

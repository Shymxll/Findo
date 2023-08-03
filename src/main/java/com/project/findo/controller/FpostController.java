package com.project.findo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.findo.dto.FpostCreateDto;
import com.project.findo.dto.FpostUpdateDto;

@RestController
@RequestMapping("/api/fpost")
public class FpostController {
    
    /**
     * API list for post of found things
     * /api/fpost/all -> get all post of found things
     * /api/fpost/{id} -> get post of found things by id
     * /api/fpost/add -> add post of found things
     * /api/fpost/update -> update post of found things
     * /api/fpost/delete -> delete post of found things
     * 
     */

    @GetMapping("/all")
    public String getAllFpost(){
        return "All post of found things";
    }

    @GetMapping("/{id}")
    public String getFpostById(@RequestParam Long id){
        return "Post of found things by id";
    }

    @PostMapping("/add")
    public String addFpost(@RequestBody FpostCreateDto fpostCreateDto){
        return "Add post of found things";
    }
    
    @PostMapping("/update")
    public String updateFpost(@RequestBody FpostUpdateDto fpostUpdateDto){
        return "Update post of found things";
    }

    @GetMapping("/delete")
    public String deleteFpost(@RequestParam Long id){
        return "Delete post of found things";
    }
}

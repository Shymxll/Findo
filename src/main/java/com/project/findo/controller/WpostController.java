package com.project.findo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.findo.dto.WpostCreateDto;



@RestController
@RequestMapping("/api/wpost")
public class WpostController {

    /**
     * API list for post of wanted things
     * /api/wpost/all -> get all post of wanted things
     * /api/wpost/{id} -> get post of wanted things by id
     * /api/wpost/add -> add post of wanted things
     * /api/wpost/update -> update post of wanted things
     * /api/wpost/delete -> delete post of wanted things
     * 
     */

    @GetMapping("/all")
    public String getAllWpost(){
        return "All post of wanted things";
    }

    @GetMapping("/{id}")
    public String getWpostById(@RequestParam Long id){
        return "Post of wanted things by id";
    }

    @PostMapping("/add")
    public String addWpost(@RequestBody WpostCreateDto wpostCreateDto){
        return "Add post of wanted things";
    }
    
    @PostMapping("/update")
    public String updateWpost(@RequestBody WpostCreateDto wpostCreateDto){
        return "Update post of wanted things";
    }

    @GetMapping("/delete")
    public String deleteWpost(@RequestParam Long id){
        return "Delete post of wanted things";
    }

    

   
}

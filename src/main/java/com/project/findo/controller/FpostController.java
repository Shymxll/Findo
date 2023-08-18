package com.project.findo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.findo.dto.FpostCreateDto;
import com.project.findo.dto.FpostUpdateDto;
import com.project.findo.entity.Fpost;
import com.project.findo.response.FpostResponse;
import com.project.findo.service.FpostService;

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

     private FpostService fpostService;

      public FpostController(FpostService fpostService){
            this.fpostService = fpostService;
        }
        


    @GetMapping("/all")
    public List<Fpost> getAllFpost(){
        return fpostService.getAllFpost();
    }

    @GetMapping("/{id}")
    public FpostResponse getFpostById(@RequestParam Long id){
        return fpostService.getFpostById(id);
    }

    @PostMapping("/add")
    public String addFpost(@RequestBody FpostCreateDto fpostCreateDto){
        return fpostService.addFpost(fpostCreateDto);
    }
    
    @PostMapping("/update")
    public String updateFpost(@RequestBody FpostUpdateDto fpostUpdateDto){
        return fpostService.updateFpost(fpostUpdateDto);
    }

    @GetMapping("/delete")
    public String deleteFpost(@RequestParam Long id){
        return fpostService.deleteFpost(id);
    }
}

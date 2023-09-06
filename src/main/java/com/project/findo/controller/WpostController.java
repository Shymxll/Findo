package com.project.findo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.findo.dto.WpostCreateDto;
import com.project.findo.dto.WpostUpdateDto;
import com.project.findo.response.WpostResponse;
import com.project.findo.service.WpostService;



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

    private WpostService wpostService;

    public WpostController(WpostService wpostService){
        this.wpostService = wpostService;
    }

    @GetMapping("/all")
    public List<WpostResponse> getAllWpost(){
        return wpostService.getAllWpost();
    }

    @GetMapping("/{id}")
    public WpostResponse getWpostById(@RequestParam Long id){
        return wpostService.getWpostById(id);
    }

    @PostMapping("/add")
    public String addWpost(@RequestBody WpostCreateDto wpostCreateDto){
        return wpostService.addWpost(wpostCreateDto);
    }
    
    @PostMapping("/update")
    public String updateWpost(@RequestBody WpostUpdateDto wpostCreateDto){
        return wpostService.updateWpost(wpostCreateDto);
    }

    @GetMapping("/delete")
    public String deleteWpost(@RequestParam Long id){
        return wpostService.deleteWpost(id);
    }

}

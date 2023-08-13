package com.project.findo.service;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.project.findo.repository.FpostRepository;
import com.project.findo.response.FpostResponse;
import com.project.findo.entity.Fpost;

@Service
public class FpostService {

    private FpostRepository fpostRepository;

    public FpostService(FpostRepository fpostRepository){
        this.fpostRepository = fpostRepository;
    }
    
    /**
     * API list for post of found things
     * /api/fpost/all -> get all post of found things
     * /api/fpost/{id} -> get post of found things by id
     * /api/fpost/add -> add post of found things
     * /api/fpost/update -> update post of found things
     * /api/fpost/delete -> delete post of found things
     * 
     */

    public List<Fpost> getAllFpost(){
       List<Fpost> optionalFpost = fpostRepository.findAll();
         if(optionalFpost != null){
              return optionalFpost;
         }
        return null;
    }

    public FpostResponse getFpostById(Long id){
        Optional<Fpost> optionalId = fpostRepository.findById(id);
        if(optionalId.isPresent()){
            Fpost fpost = optionalId.get();
            FpostResponse fpostResponse = FpostResponse.builder()
                .id(fpost.getId())
                .text(fpost.getText())
                .category(fpost.getCategory())
                .question(fpost.getQuestion())
                .country(fpost.getCountry())
                .city(fpost.getCity())
                .mapLocation(fpost.getMapLocation())
                .createdDate(fpost.getCreatedDate())
                .updatedDate(fpost.getUpdatedDate())
                .build();
            return fpostResponse;
        }
        return null;
         
    }

    public String addFpost(){
        return "Add post of found things";
    }
    
    public String updateFpost(){
        return "Update post of found things";
    }

    public String deleteFpost(Long id){
        return "Delete post of found things";
    }
}

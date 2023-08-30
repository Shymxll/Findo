package com.project.findo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.project.findo.repository.FpostRepository;
import com.project.findo.repository.UserRepository;
import com.project.findo.response.FpostResponse;
import com.project.findo.response.WpostResponse;
import com.project.findo.dto.FpostCreateDto;
import com.project.findo.dto.FpostUpdateDto;
import com.project.findo.entity.Fpost;
import com.project.findo.entity.User;
import com.project.findo.entity.Wpost;

@Service
public class FpostService {

    private FpostRepository fpostRepository;
    private UserRepository userRepository;

        /**
     * API list for post of found things
     * /api/fpost/all -> get all post of found things
     * /api/fpost/{id} -> get post of found things by id
     * /api/fpost/add -> add post of found things
     * /api/fpost/update -> update post of found things
     * /api/fpost/delete -> delete post of found things
     * 
     */

    public FpostService(FpostRepository fpostRepository, UserRepository userRepository){
        this.fpostRepository = fpostRepository;
        this.userRepository = userRepository;
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

    public String addFpost(FpostCreateDto fpostCreateDto){
        // find user by id
        long userId = fpostCreateDto.getUserId();
        System.out.println(userId);
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            Fpost fpost = Fpost.builder()
                .user(user)
                .text(fpostCreateDto.getText())
                .category(fpostCreateDto.getCategory())
                .country(fpostCreateDto.getCountry())
                .city(fpostCreateDto.getCity())
                .question(fpostCreateDto.getQuestion())
                .answer(fpostCreateDto.getAnswer())
                .mapLocation(fpostCreateDto.getMapLocation())
                .createdDate(new Date().toString())
                .updatedDate(new Date().toString())
                .build();
            try {
                fpostRepository.save(fpost);
            } catch (Exception e) {
                return "Error";
            };
            return "Success";
        }
        return "Error";
    }
    
    public String updateFpost(FpostUpdateDto fpostUpdateDto){
        // find user by id
        long id = fpostUpdateDto.getId();
        Optional<Fpost> optionalFpost = fpostRepository.findById(id);
        if(optionalFpost.isPresent()){
            Fpost fpost = optionalFpost.get();
            Fpost uptFpost = Fpost.builder()
                .id(fpost.getId())
                .user(fpost.getUser())
                .text(fpostUpdateDto.getText())
                .category(fpostUpdateDto.getCategory())
                .country(fpostUpdateDto.getCountry())
                .city(fpostUpdateDto.getCity())
                .question(fpostUpdateDto.getQuestion())
                .answer(fpostUpdateDto.getAnswer())
                .mapLocation(fpostUpdateDto.getMapLocation())
                .createdDate(fpost.getCreatedDate())
                .updatedDate(new Date().toString())
                .build();
            try {
                fpostRepository.save(uptFpost);
            } catch (Exception e) {
                return "Error";
            };
            return "Success";
        }
        return "Error";
        
    }

    public String deleteFpost(Long id){
        Optional<Fpost> optionalFpost = fpostRepository.findById(id);
        if(optionalFpost.isPresent()){
            try {
                fpostRepository.deleteById(id);
            } catch (Exception e) {
                return "Error";
            };
            return "Success";
        }
        return "Error";
    }

    public List<FpostResponse> getAllFpost() {
       List<Fpost> fposts = fpostRepository.findAll();
       List<FpostResponse> fpostResponses = new ArrayList<>();
         if(fposts != null){
             for (Fpost fpost : fposts) {
                 FpostResponse fpostResponse = FpostResponse.builder()
                     .id(fpost.getId())
                     .text(fpost.getText())
                     .userId(fpost.getUser().getId())
                     .category(fpost.getCategory())
                     .question(fpost.getQuestion())
                     .country(fpost.getCountry())
                     .city(fpost.getCity())
                     .mapLocation(fpost.getMapLocation())
                     .createdDate(fpost.getCreatedDate())
                     .updatedDate(fpost.getUpdatedDate())
                     .build();
                    fpostResponses.add(fpostResponse);
             }
                return fpostResponses;
            }
        return null;
    }
}

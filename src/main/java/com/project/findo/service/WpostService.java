package com.project.findo.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.findo.dto.WpostCreateDto;
import com.project.findo.dto.WpostUpdateDto;
import com.project.findo.entity.User;
import com.project.findo.entity.Wpost;
import com.project.findo.repository.UserRepository;
import com.project.findo.repository.WpostRepository;
import com.project.findo.response.WpostResponse;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Service
public class WpostService {

    private WpostRepository wpostRepository;
    private UserRepository userRepository;

    public WpostService(WpostRepository wpostRepository) {
        this.wpostRepository = wpostRepository;
    }

    public String addWpost(@RequestBody WpostCreateDto wpostCreateDto) {

        Optional<User> user = userRepository.findById(wpostCreateDto.getUserId());
        if (user.isPresent()) {
            try {
                Wpost wpost = Wpost.builder()
                        .text(wpostCreateDto.getText())
                        .category(wpostCreateDto.getCategory())
                        .question(wpostCreateDto.getQuestion())
                        .country(wpostCreateDto.getCountry())
                        .city(wpostCreateDto.getCity())
                        .mapLocation(wpostCreateDto.getMapLocation())
                        .createdDate(new Date().toString())
                        .updatedDate(new Date().toString())
                        .user(user.get())
                        .build();
                wpostRepository.save(wpost);
            } catch (Exception e) {
                return "failed";
            }
            return "success";
        }
        return "user not found";
    
    }

    

    public WpostResponse getWpostById(Long id) {
        Optional<Wpost> optionalId = wpostRepository.findById(id);
        if (optionalId.isPresent()) {
            Wpost wpost = optionalId.get();
            WpostResponse wpostResponse = WpostResponse.builder()
                    .id(wpost.getId())
                    .text(wpost.getText())
                    .category(wpost.getCategory())
                    .question(wpost.getQuestion())
                    .country(wpost.getCountry())
                    .city(wpost.getCity())
                    .mapLocation(wpost.getMapLocation())
                    .createdDate(wpost.getCreatedDate())
                    .updatedDate(wpost.getUpdatedDate())
                    .build();
            return wpostResponse;
        }

        return WpostResponse.builder().build();
    }

    public String updateWpost(WpostUpdateDto wpostUpdateDto) {
        Optional<Wpost> optionalId = wpostRepository.findById(wpostUpdateDto.getId());
        if (optionalId.isPresent()) {
            Wpost wpost = optionalId.get();
            wpost.setText(wpostUpdateDto.getText());
            wpost.setCategory(wpostUpdateDto.getCategory());
            wpost.setQuestion(wpostUpdateDto.getQuestion());
            wpost.setCountry(wpostUpdateDto.getCountry());
            wpost.setCity(wpostUpdateDto.getCity());
            wpost.setMapLocation(wpostUpdateDto.getMapLocation());
            wpost.setUpdatedDate(new Date().toString());
            try {
                wpostRepository.save(wpost);
            } catch (Exception e) {
                return "failed";
            }
            return "success";
        }
        return "id not found";
    }

    public String deleteWpost(Long id) {
        Optional<Wpost> optionalId = wpostRepository.findById(id);
        if (optionalId.isPresent()) {
            try {
                wpostRepository.deleteById(id);
            } catch (Exception e) {
                return "failed";
            }
            return "success";
        }
        return "id not found";
    }
}

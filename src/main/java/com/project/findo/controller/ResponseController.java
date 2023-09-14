package com.project.findo.controller;

import com.project.findo.dto.ResponseCreateDto;
import com.project.findo.dto.ResponseUpdateDto;
import com.project.findo.response.RespResponse;
import com.project.findo.response.UserRespResponse;
import com.project.findo.service.ResponseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/response")
public class ResponseController {
    /*
    * /api/response/{id} GET get response by id
    * /api/response/update POST update response
    * /api/response/{id} GET delete response
    * /api/response/add POST add response
    * /api/response/{post_id} GET get responses by post id
    * /api/response/{user_id} GET get responses by user id
    *
    * */

    private final ResponseService responseService;

    public ResponseController(ResponseService responseService) {
        this.responseService = responseService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<RespResponse> getResponseById(@PathVariable Long id){
        return ResponseEntity.ok(responseService.getResponseById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<String> addResponse(@RequestBody ResponseCreateDto responseCreateDto){
        return ResponseEntity.ok(responseService.addResponse(responseCreateDto));
    }

    @GetMapping("/{post_id}")
    public ResponseEntity<List<RespResponse>> getResponsesByPostId(@PathVariable Long post_id){
        return ResponseEntity.ok(responseService.getResponsesByPostId(post_id));
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<List<UserRespResponse>> getResponsesByUserId(@PathVariable Long user_id){
        return ResponseEntity.ok(responseService.getResponsesByUserId(user_id));
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateResponse(@RequestBody ResponseUpdateDto responseUpdateDto){
        return ResponseEntity.ok(responseService.updateResponse(responseUpdateDto));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteResponse(@RequestParam Long id){
        return ResponseEntity.ok(responseService.deleteResponse(id));
    }

    @GetMapping("/owner")
    public ResponseEntity<List<RespResponse>> getResponsesOwnerPost(@RequestParam Long post_id, @RequestParam Long post_owner_id){
        return ResponseEntity.ok(responseService.getResponsesOwnerPost(post_id, post_owner_id));
    }

}





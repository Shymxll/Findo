package com.project.findo.controller;

import com.project.findo.dto.AuthenticationDto;
import com.project.findo.dto.RegisterDto;
import com.project.findo.response.AuthenticationResponse;
import com.project.findo.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthenticationController{

    private final AuthenticationService service;

    public AuthenticationController(AuthenticationService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
        @RequestBody RegisterDto request
    ) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/auth")
    public ResponseEntity<AuthenticationResponse> authenticate(
        @RequestBody AuthenticationDto request
    ) {
        System.out.println(request);
        return ResponseEntity.ok(service.authenticate(request));
    }

    //test
    @PostMapping("/test")
    public ResponseEntity<String> test(
        @RequestBody String request
    ) {
        System.out.println(request);
        return ResponseEntity.ok(request);
    }

}

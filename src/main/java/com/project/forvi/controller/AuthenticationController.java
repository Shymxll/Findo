package com.project.forvi.controller;

import com.project.forvi.dto.AuthenticationDto;
import com.project.forvi.dto.RegisterDto;
import com.project.forvi.response.AuthenticationResponse;
import com.project.forvi.service.AuthenticationService;
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
    public ResponseEntity<AuthenticationResponse> register(//
        @RequestBody RegisterDto request
    ) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/auth")
    public ResponseEntity<AuthenticationResponse> authenticate(
        @RequestBody AuthenticationDto request
    ) {

        return ResponseEntity.ok(service.authenticate(request));
    }


}

package com.project.forvi.service;

import com.project.forvi.dto.AuthenticationDto;
import com.project.forvi.dto.RegisterDto;
import com.project.forvi.entity.Role;
import com.project.forvi.entity.User;
import com.project.forvi.repository.UserRepository;
import com.project.forvi.response.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterDto request) {
        var user = User.builder()
            .firstname(request.getFirstname())
            .lastname(request.getLastname())
            .email(request.getEmail())
            .phone(request.getPhone())
            .createdDate(new Date())
            .updatedDate(new Date())
            .psw(passwordEncoder.encode(request.getPassword()))
            .role(Role.USER)
            .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
            .token(jwtToken)
            .build();
    }

    public AuthenticationResponse authenticate(AuthenticationDto request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getEmail(),

                request.getPassword()
            )
        );
            var user = userRepository.findByEmail(request.getEmail());
            var jwtToken = jwtService.generateToken(user.get());
            return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}

package com.project.findo.service;

import com.project.findo.dto.AuthenticationDto;
import com.project.findo.dto.RegisterDto;
import com.project.findo.entity.Role;
import com.project.findo.entity.User;
import com.project.findo.repository.UserRepository;
import com.project.findo.response.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
        System.out.println("authenticate");
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getEmail(),

                request.getPassword()
            )
        );
            System.out.println(request.getEmail());
            var user = userRepository.findByEmail(request.getEmail());
            System.out.println(user);
            var jwtToken = jwtService.generateToken(user.get());
            return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}

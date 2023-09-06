package com.project.findo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    //UNSECURED ENDPOINTS
    final String[] UNSECURED = new String [] {
        "/",
        "/swagger-ui/**",
        "/swagger-ui.html",
        "/v3/api-docs/**",
        "/swagger-resources/**",
        "/webjars/**",
        "/h2-console/**",
        "/login",
        "/api/register"
    

    };

    final String[] SECURED = new String [] {
        "/api/fpost/all",
        "/api/fpost/{id}",
        "/api/fpost/add",
        "/api/fpost/update",
        "/api/fpost/delete",
        "/api/fpost/add",
        "/api/wpost/all",
        "/api/wpost/{id}",
        "/api/wpost/add",
        "/api/wpost/update",
        "/api/wpost/delete"
    };


    

    //filter chain for authentication
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        
       http
       .csrf(csrf -> csrf.disable())
       .authorizeHttpRequests((request) -> request
            .requestMatchers(SECURED).authenticated()
            .requestMatchers(UNSECURED).permitAll()
            
            )
            .formLogin(Customizer.withDefaults())
            .httpBasic(Customizer.withDefaults()); 
    
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

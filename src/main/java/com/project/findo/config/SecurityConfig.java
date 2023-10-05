package com.project.findo.config;

import com.project.findo.filter.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private JwtAuthenticationFilter authenticationFilter;
    private AuthenticationProvider authenticationProvider;

    public SecurityConfig(JwtAuthenticationFilter authenticationFilter, AuthenticationProvider authenticationProvider) {
        this.authenticationFilter = authenticationFilter;
        this.authenticationProvider = authenticationProvider;
    }



    //UNSECURED ENDPOINTS
    final String[] UNSECURED = new String [] {
        "/",
        "/swagger-ui/**",
        "/swagger-ui.html",
        "/v3/api-docs/**",
        "/swagger-resources/**",
        "/webjars/**",
        "/h2-console/**",
        "/api/auth",
        "/api/register"
    };

    final String[] SECURED = new String [] {
    "/api/test",
    };

    //filter chain for authentication
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

       http.csrf(csrf -> csrf.disable())
               .authorizeHttpRequests((request) -> request
                               .requestMatchers(SECURED).authenticated()
                               .requestMatchers(UNSECURED).permitAll()
                               .anyRequest().permitAll())
               .sessionManagement(sessionManagement -> sessionManagement
                       .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
               .authenticationProvider(authenticationProvider)
               .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);
    
        return http.build();
    }






}

package com.project.findo.config;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.findo.entity.User;
import com.project.findo.repository.UserRepository;

@Service
public class AppUserDetails implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String userName, password,hashPsw;
        List<GrantedAuthority> authorities;
        List<User> user = userRepository.findByEmail(username);
        if (user.size() == 0) {
            throw new UsernameNotFoundException("User details not found for the user : " + username);
        } else{
            userName = user.get(0).getEmail();
            password = user.get(0).getPsw();

            System.out.println("User details found for the user : " + username);
            System.out.println("User details found for the user : " + password);
  
    
            authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(user.get(0).getRole()));
        }
        return new org.springframework.security.core.userdetails.User(userName,password, authorities);
    
    }
    
    
}

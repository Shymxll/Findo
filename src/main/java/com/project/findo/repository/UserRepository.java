package com.project.findo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.findo.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

    List<User> findByEmail(String email);
    
}

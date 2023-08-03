package com.project.findo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.findo.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}

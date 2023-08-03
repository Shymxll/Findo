package com.project.findo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.findo.entity.Fpost;

public interface FpostRepository extends JpaRepository<Fpost, Long>{
    
    
}

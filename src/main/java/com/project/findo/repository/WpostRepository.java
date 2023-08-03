package com.project.findo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.findo.entity.Wpost;

public interface WpostRepository extends JpaRepository<Wpost, Long>{
    
}

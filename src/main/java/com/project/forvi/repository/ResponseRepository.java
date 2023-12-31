package com.project.forvi.repository;

import com.project.forvi.entity.Response;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ResponseRepository  extends JpaRepository<Response, Long> {

    Optional<List<Response>> findByPostId(Long postId);
}

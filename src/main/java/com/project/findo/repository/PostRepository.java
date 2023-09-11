package com.project.findo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.findo.entity.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long>{

    @Query(value = "SELECT * FROM post ORDER BY id DESC LIMIT :limit OFFSET :offset ", nativeQuery = true)
    Optional<List<Post>> findReversePostsBeforeIdBy(@Param("limit") long limit, @Param("offset") long offset);
}

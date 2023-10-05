package com.project.findo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.findo.entity.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long>{

    @Query(value = "SELECT * FROM post ORDER BY id DESC LIMIT :limit OFFSET :offset ", nativeQuery = true)
    Optional<List<Post>> findReversePostsBeforeIdBy(@Param("limit") long limit, @Param("offset") long offset);

    //search by city , country , category , worf , created_date but maybe null any field, so we use @Nullable ,

    @Query(value = "SELECT * FROM post WHERE (:category IS NULL OR category = :category) AND (:city IS NULL OR city = :city) AND (:country IS NULL OR country = :country) AND (:text IS NULL OR text = :text) AND (:createdDate IS NULL OR created_date = :createdDate) ORDER BY id DESC LIMIT :limit OFFSET :offset ", nativeQuery = true)
    Optional<List<Post>> searchBy(
            //category, city, country,text, worf, createdDate,limit, offset
            @Param("category")  String category,
            @Param("city")  String city,
            @Param("country")  String country,
            @Param("text")  String text,
            @Param("createdDate")  Date createdDate,
            @Param("limit") Long limit,
            @Param("offset") Long offset
    );

}

package com.project.findo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.findo.dto.PostCreateDto;
import com.project.findo.dto.PostUpdateDto;
import com.project.findo.response.PostResponse;
import com.project.findo.service.PostService;

@RestController
@RequestMapping("/api/post")
public class PostController {
    /**
     * API list for post of found things
     * /api/post/all -> get all post of found things
     * /api/post/{id} -> get post of found things by id
     * /api/post/add -> add post of found things
     * /api/post/update -> update post of found things
     * /api/post/delete -> delete post of found things
     * /api/post/reverse-posts-by-range -> get reverse posts by range
     */

    @Autowired
     private PostService postService;

      public PostController(){

        }


    @GetMapping("/{id}")
    public PostResponse getPostById(@RequestParam Long id){
        return postService.getPostById(id);
    }

    @PostMapping("/add")
    public String addPost(@RequestBody PostCreateDto postCreateDto){
       
        return postService.addPost(postCreateDto);
    }
    
    @PostMapping("/update")
    public String updatePost(@RequestBody PostUpdateDto postUpdateDto){
        return postService.updatePost(postUpdateDto);
    }

    @GetMapping("/delete")
    public String deletePost(@RequestParam Long id){
        return postService.deletePost(id);
    }

    @PostMapping("/reverse-posts-by-range")
    public List<PostResponse> getReversePostsByRange(@RequestParam Long limit , @RequestParam Long offset){
        return postService.findReversePostsBeforeIdBy(limit, offset);
    }






}

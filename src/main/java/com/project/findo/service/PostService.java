package com.project.findo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.project.findo.repository.PostRepository;
import com.project.findo.repository.UserRepository;
import com.project.findo.response.PostResponse;
import com.project.findo.dto.PostCreateDto;
import com.project.findo.dto.PostUpdateDto;
import com.project.findo.entity.Post;
import com.project.findo.entity.User;

@Service
public class PostService {
    private PostRepository postRepository;
    private UserRepository userRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository){
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public PostResponse getPostById(Long id){
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent() && post.get().getStatus() == 1){ // check if post is exist and status is 1 (active)
            return PostResponse.builder()
                    .id(post.get().getId())
                    .worf(post.get().getWorf())
                    .text(post.get().getText())
                    .image(post.get().getImage())
                    .category(post.get().getCategory())
                    .question(post.get().getQuestion())
                    .country(post.get().getCountry())
                    .city(post.get().getCity())
                    .mapLocation(post.get().getMapLocation())
                    .createdDate(post.get().getCreatedDate())
                    .build();

        }
        return PostResponse.builder().build();
         
    }

    public String addPost(PostCreateDto postCreateDto){
        Optional<User> user = userRepository.findById(postCreateDto.getUserId());
        if (user.isPresent()){
            Post post = Post.builder()
                    .user(user.get())
                    .text(postCreateDto.getText())
                    .category(postCreateDto.getCategory())
                    .image(postCreateDto.getImage())
                    .worf(postCreateDto.getWorf())
                    .country(postCreateDto.getCountry())
                    .city(postCreateDto.getCity())
                    .question(postCreateDto.getQuestion())
                    .answer(postCreateDto.getAnswer())
                    .mapLocation(postCreateDto.getMapLocation())
                    .status((short) 1)
                    .createdDate(new Date())
                    .updatedDate(new Date())
                    .build();
            postRepository.save(post);
            return "Post added successfully";
        }
        return "User not found";
    }
    
    public String updatePost(PostUpdateDto postUpdateDto){
        Optional<Post> post = postRepository.findById(postUpdateDto.getId());
        if (post.isPresent()){
            post.get().setText(postUpdateDto.getText());
            post.get().setCategory(postUpdateDto.getCategory());
            post.get().setImage(postUpdateDto.getImage());
            post.get().setCountry(postUpdateDto.getCountry());
            post.get().setCity(postUpdateDto.getCity());
            post.get().setQuestion(postUpdateDto.getQuestion());
            post.get().setAnswer(postUpdateDto.getAnswer());
            post.get().setMapLocation(postUpdateDto.getMapLocation());
            post.get().setUpdatedDate(new Date());
            postRepository.save(post.get());
            return "Post updated successfully";
        }
        return "Post not found";
    }

    public String deletePost(Long id){
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()){
            post.get().setStatus((short) 0);
            post.get().setUpdatedDate(new Date());
            postRepository.save(post.get());
            return "Post deleted successfully";
        }
        return "Post not found";
    }

   public List<PostResponse> findReversePostsBeforeIdBy(Long limit, Long offset){
       Optional<List<Post>> posts = postRepository.findReversePostsBeforeIdBy(limit, offset);
         if (posts.isPresent()){
              List<PostResponse> postResponses = new ArrayList<>();
              for (Post post : posts.get()){
                PostResponse postResponse = PostResponse.builder()
                          .id(post.getId())
                          .worf(post.getWorf())
                          .text(post.getText())
                          .image(post.getImage())
                          .category(post.getCategory())
                          .question(post.getQuestion())
                          .country(post.getCountry())
                          .city(post.getCity())
                          .mapLocation(post.getMapLocation())
                          .createdDate(post.getCreatedDate())
                          .build();
                postResponses.add(postResponse);
              }
              return postResponses;
         }
       return new ArrayList<>();
    }

}



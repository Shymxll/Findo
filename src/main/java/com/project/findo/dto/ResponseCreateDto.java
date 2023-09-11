package com.project.findo.dto;


import lombok.Data;

@Data
public class ResponseCreateDto {
    Long userId; // who is responding to the post
    Long postId; // which post is being responded to
    String response; // the response itself
}

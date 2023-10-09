package com.project.forvi.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCreateDto {
    Long userId; // who is responding to the post
    Long postId; // which post is being responded to
    String response; // the response itself
}

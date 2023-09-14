package com.project.findo.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRespResponse {
    String name;
    String response;
    String postAnswer;
}

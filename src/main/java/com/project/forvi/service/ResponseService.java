package com.project.forvi.service;

import com.project.forvi.dto.ResponseCreateDto;
import com.project.forvi.dto.ResponseUpdateDto;
import com.project.forvi.entity.Response;
import com.project.forvi.repository.PostRepository;
import com.project.forvi.repository.ResponseRepository;
import com.project.forvi.repository.UserRepository;
import com.project.forvi.response.RespResponse;
import com.project.forvi.response.UserRespResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResponseService {
    private final ResponseRepository responseRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    //constructor
    public ResponseService(ResponseRepository responseRepository, UserRepository userRepository, PostRepository postRepository) {
        this.responseRepository = responseRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public String updateResponse(ResponseUpdateDto responseUpdateDto) {
        if (isResponseExist(responseUpdateDto.getId())) {
            Optional<Response> response = responseRepository.findById(responseUpdateDto.getId());
            if (response.isPresent()) {
                response.get().setResponse(responseUpdateDto.getResponse());
                responseRepository.save(response.get());
            }
            return "Response updated successfully!";
        } else {
            return "Error updating response!";
        }
    }
    public RespResponse getResponseById(Long id) {
        Optional<Response> response = responseRepository.findById(id);
        if (response.isPresent()) {
            RespResponse respResponse = new RespResponse();
            respResponse.setResponse(response.get().getResponse());
            respResponse.setName(response.get().getUser().getFirstname());
            return respResponse;
        }
        return RespResponse.builder().build();
    }

    private void saveResponse(ResponseCreateDto responseCreateDto) {
        Response response = new Response();
        response.setResponse(responseCreateDto.getResponse());
        response.setUser(userRepository.findById(responseCreateDto.getUserId()).get());
        response.setPost(postRepository.findById(responseCreateDto.getPostId()).get());
        responseRepository.save(response);
    }

    public List<RespResponse> getResponsesByPostId(Long postId) {
        if (isPostExists(postId)) {
            try {
                Optional<List<Response>> responses = responseRepository.findByPostId(postId);
                List<RespResponse> respResponses = List.of();
                if (responses.isPresent()) {
                    for (Response response : responses.get()) {
                        RespResponse respResponse = new RespResponse();
                        respResponse.setResponse(response.getResponse());
                        respResponse.setPhone(response.getUser().getPhone());
                        respResponse.setEmail(response.getUser().getEmail());
                        respResponse.setName(response.getUser().getFirstname());
                        respResponses.add(respResponse);
                    }
                    return respResponses;
                } else {
                    return List.of();
                }
            } catch (Exception e) {
                return List.of();
            }
        }
        return List.of();
    }

    public List<UserRespResponse> getResponsesByUserId(Long userId) {
        if (isUserExists(userId)) {
            try {
                Optional<List<Response>> responses = responseRepository.findByPostId(userId);
                List<UserRespResponse> userRespResponses = List.of();
                if (responses.isPresent()) {
                    for (Response response : responses.get()) {
                        UserRespResponse userRespResponse = new UserRespResponse();
                        userRespResponse.setName(response.getUser().getFirstname());
                        userRespResponse.setResponse(response.getResponse());
                        userRespResponse.setPostAnswer(response.getPost().getAnswer());
                        userRespResponses.add(userRespResponse);
                    }
                    return userRespResponses;
                } else {
                    return List.of();
                }
            } catch (Exception e) {
                return List.of();
            }
        }
        return List.of();
    }

    private boolean isUserExists(Long userId) {
        return userRepository.findById(userId).isPresent();
    }
    private boolean isResponseNotEmpty(String response) throws NullPointerException {
        return response != null && !response.equals("");
    }

    private boolean isPostExists(Long postId) throws NullPointerException{
        return postRepository.findById(postId).isPresent();
    }

    private boolean isResponseExist(Long responseId) throws NullPointerException {

        return responseRepository.findById(responseId).isPresent();
    }

    private boolean isValidResponse(ResponseCreateDto responseCreateDto) {
        return isUserExists(responseCreateDto.getUserId()) &&
                isPostExists(responseCreateDto.getPostId()) &&
                isResponseNotEmpty(responseCreateDto.getResponse());
    }

    public String addResponse(ResponseCreateDto responseCreateDto) {
        if (isValidResponse(responseCreateDto)) {
            saveResponse(responseCreateDto);
            return "Response added successfully!";
        } else {
            return "Error adding response!";
        }
    }

    public boolean deleteResponse(Long id) {
        if (isResponseExist(id)) {
            responseRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public List<RespResponse> getResponsesOwnerPost(Long postId, Long postOwnerId) {
        if(isPostExists(postId) && isUserExists(postOwnerId)){
            if (postRepository.findById(postId).get().getUser().getId().equals(postOwnerId)){
                for (Response response : responseRepository.findByPostId(postId).get()) {
                    RespResponse respResponse = new RespResponse();
                    respResponse.setResponse(response.getResponse());
                    respResponse.setPhone(response.getUser().getPhone());
                    respResponse.setEmail(response.getUser().getEmail());
                    respResponse.setName(response.getUser().getFirstname());
                    return List.of(respResponse);
                }
            }
            return List.of();
        }
        return List.of();
    }
}


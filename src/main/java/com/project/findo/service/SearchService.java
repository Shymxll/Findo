package com.project.findo.service;

import org.springframework.stereotype.Service;

import com.project.findo.repository.FpostRepository;
import com.project.findo.repository.WpostRepository;

@Service
public class SearchService {
    private WpostRepository wpostRepository;
    private FpostRepository fpostRepository;
}

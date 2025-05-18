package com.vibecheck.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class QuizService {

    public String calculateVibe(List<Integer> answers) {
        int sum = answers.stream().mapToInt(i -> i).sum();
        int avg = sum / answers.size();

        return switch (avg % 5) {
            case 0 -> "Zen Dev";
            case 1 -> "Logic Lord";
            case 2 -> "Creative Coder";
            case 3 -> "Cool Collaborator";
            default -> "Speedy Debugger";
        };
    }
}
package com.vibecheck.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vibecheck.model.Question;
import com.vibecheck.model.Submission;
import com.vibecheck.repository.QuestionRepository;
import com.vibecheck.repository.SubmissionRepository;
import com.vibecheck.service.QuizService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
@RequiredArgsConstructor
public class QuizController {

    private final QuestionRepository questionRepo;
    private final SubmissionRepository submissionRepo;
    private final QuizService quizService;

    @GetMapping("/quiz")
    public List<Question> getQuiz() {
        return questionRepo.findAll();
    }

    @PostMapping("/quiz/submit")
    public Map<String, String> submitQuiz(@RequestBody Map<String, List<Integer>> body) {
        List<Integer> answers = body.get("answers");
        String vibe = quizService.calculateVibe(answers);
        submissionRepo.save(new Submission(null, vibe, LocalDateTime.now()));
        return Map.of("vibe", vibe);
    }

    @GetMapping("/results")
    public Map<String, Long> getResults() {
        List<Submission> all = submissionRepo.findAll();
        Map<String, Long> counts = new HashMap<>();
        for (Submission s : all) {
            counts.put(s.getVibe(), counts.getOrDefault(s.getVibe(), 0L) + 1);
        }
        return counts;
    }
}

package com.abhinav.quizapp.controller;

import com.abhinav.quizapp.dto.QuizDto;
import com.abhinav.quizapp.model.Response;
import com.abhinav.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")

public class QuizController {
    @Autowired
    QuizService quizService;
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam Integer numQ, @RequestParam String tittle){
        return quizService.createQuiz(category, numQ, tittle);
    }
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuizDto>> getQuizQuestion(@PathVariable Integer id){
        return quizService.getQuizQuestion(id);
    }
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> response){
        return quizService.calculateResult(id,response);
    }


}

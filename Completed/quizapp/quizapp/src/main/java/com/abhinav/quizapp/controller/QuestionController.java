package com.abhinav.quizapp.controller;

import com.abhinav.quizapp.dto.QuestionDto;
import com.abhinav.quizapp.model.Questions;
import com.abhinav.quizapp.service.QuestionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questions")
@Validated
public class QuestionController {
    @Autowired
    QuestionService questionservice;
    @GetMapping("Allquestions")
    public ResponseEntity<List<Questions>> getAllquestions(){
        return questionservice.getAllquestions();
    }
    @GetMapping("category/{category}")

    public ResponseEntity<List<Questions>> getQuestionByCategory(@PathVariable  String category){
        return questionservice.getQuestionByCategory(category);
    }
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@Valid  @RequestBody Questions question){
        return questionservice.addQuestion(question);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<String> updateQuestion (@PathVariable Integer id, @RequestBody Questions question ){
        return questionservice.updateQuestion(id, question);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteQuestion (@PathVariable Integer id){
        return questionservice.deleteQuestion(id);
    }

}

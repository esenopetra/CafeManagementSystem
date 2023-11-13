package com.abhinav.quizapp.service;

import com.abhinav.quizapp.dto.QuestionDto;
import com.abhinav.quizapp.model.Questions;
import com.abhinav.quizapp.repository.QuestionRepository;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class QuestionService {
    @Autowired
    QuestionRepository questionRepository;

    public ResponseEntity<List<Questions>> getAllquestions(){
        try {
            return new  ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }

        return new  ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

//        List<Questions> questionsList = questionRepository.findAll();
//
//        return questionsList.stream()
//                .map(question -> {
//                    QuestionDto dto = new QuestionDto();
//                    dto.setId(question.getId());
//                    dto.setCategory(question.getCategory());
//                    dto.setDifficultylevel(question.getDifficultylevel());
//                    dto.setOption1(question.getOption1());
//                    dto.setOption2(question.getOption2());
//                    dto.setOption3(question.getOption3());
//                    dto.setQuestion(question.getQuestion());
//                    return dto;
//                })
//                .collect(Collectors.toList());

    }

    public ResponseEntity<List<Questions>> getQuestionByCategory(String category) {
        try {
            return new ResponseEntity<>(questionRepository.findByCategory(category), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Questions question) {
        try {
            questionRepository.save(question);
            return  ResponseEntity.status(HttpStatus.OK).body("Success");
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong :(");
    }


    public ResponseEntity<String> updateQuestion(Integer id, Questions question) {
        try {
            Optional<Questions> exiquestion = questionRepository.findById(id);
            //try catch -- Input error  2
            if (exiquestion.isPresent()) {
                Questions questions = exiquestion.get();
                questions.setQuestion(question.getQuestion());
                questions.setCategory(question.getCategory());
                questions.setDifficultylevel(question.getDifficultylevel());
                questions.setOption1(question.getOption1());
                questions.setOption2(question.getOption2());
                questions.setOption3(question.getOption3());
                questions.setRightanswer(question.getRightanswer());
                questionRepository.save(questions);
                return ResponseEntity.ok("Updated");
            }
            else {
                return ResponseEntity.noContent().build();
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Some error in updating the question");
        }
    }

    public ResponseEntity<String> deleteQuestion(Integer id) {
        try {
            questionRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Deleted");
        }catch (Exception e){
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Deleted");
    }



}

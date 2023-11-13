package com.abhinav.quizapp.service;

import com.abhinav.quizapp.dto.QuizDto;
import com.abhinav.quizapp.model.Questions;
import com.abhinav.quizapp.model.Quiz;
import com.abhinav.quizapp.model.Response;
import com.abhinav.quizapp.repository.QuestionRepository;
import com.abhinav.quizapp.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class QuizService {
    @Autowired
    QuizRepository quizRepository;
    @Autowired
    QuestionRepository questionRepository;


    public ResponseEntity<String> createQuiz(String category, Integer numQ, String tittle) {
        List<Questions> questions = questionRepository.findRandomQuestionsByCategory(category,numQ);


        Quiz quiz = new Quiz();
        quiz.setTitle(tittle);
        quiz.setQuestions(questions);
        quizRepository.save(quiz);
        return new ResponseEntity<>("Sucess", HttpStatus.CREATED);

    }

    public ResponseEntity<List<QuizDto>> getQuizQuestion(Integer id) { //Doubt
      Optional<Quiz> quiz = quizRepository.findById(id);
      List<Questions> questionsFromDB = quiz.get().getQuestions();
      List<QuizDto> questionForUser = new ArrayList<>();
      for (Questions q : questionsFromDB){
          QuizDto qw = new QuizDto(q.getId(),q.getQuestion(),q.getOption1(), q.getOption2(), q.getOption3());
          questionForUser.add(qw);
      }

      return new ResponseEntity<>(questionForUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz = quizRepository.findById(id).get();
        List<Questions> questions = quiz.getQuestions();
        int right =0;
        int i=0;
        for (Response response: responses){
            if (response.getResponse().equals(questions.get(i).getRightanswer()))
                right++;
            i++;
        }
    return new ResponseEntity<>(right,HttpStatus.OK);

    }
}

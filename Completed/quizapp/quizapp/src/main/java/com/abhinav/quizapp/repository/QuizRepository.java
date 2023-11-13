package com.abhinav.quizapp.repository;

import com.abhinav.quizapp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface QuizRepository extends JpaRepository<Quiz, Integer> {
}

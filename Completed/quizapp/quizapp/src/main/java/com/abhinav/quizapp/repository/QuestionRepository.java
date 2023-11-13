package com.abhinav.quizapp.repository;

import com.abhinav.quizapp.model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface QuestionRepository extends JpaRepository<Questions, Integer> {

    List<Questions> findByCategory(String category);
    @Query(value = "SELECT * FROM questions q WHERE q.category=:category ORDER BY RAND() LIMIT :numQ",nativeQuery = true)

    List<Questions> findRandomQuestionsByCategory(String category, Integer numQ);
}

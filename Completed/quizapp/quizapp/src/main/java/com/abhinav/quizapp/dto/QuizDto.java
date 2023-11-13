package com.abhinav.quizapp.dto;

import lombok.Data;

@Data
public class QuizDto {
    private Integer id;
    private String question;
    private String option1;
    private String option2;
    private String option3;

    public QuizDto(Integer id, String question, String option1, String option2, String option3) {
        this.id = id;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
    }
}

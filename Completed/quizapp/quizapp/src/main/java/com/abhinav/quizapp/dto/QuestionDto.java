package com.abhinav.quizapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {
    private Integer id;

    private String category;

    private String difficultylevel;

    private String option1;

    //    @Column(nullable = false)
    private String option2;

    //    @Column(nullable = false)
    private String option3;

    //    @Column(nullable = false)
    private String question;
}

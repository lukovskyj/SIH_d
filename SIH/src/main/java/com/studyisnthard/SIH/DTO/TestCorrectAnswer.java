package com.studyisnthard.SIH.DTO;


import java.util.ArrayList;

public class TestCorrectAnswer {

    public ArrayList<String> correct_answer;
    public Long id;

    public TestCorrectAnswer(){}

    public TestCorrectAnswer(ArrayList<String> correct_answer, Long id) {
        this.correct_answer = correct_answer;
        this.id = id;
    }

    public ArrayList<String> getCorrect_answer() {
        return correct_answer;
    }

    public void setCorrect_answer(ArrayList<String> correct_answer) {
        this.correct_answer = correct_answer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

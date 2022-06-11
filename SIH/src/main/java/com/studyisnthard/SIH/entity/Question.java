package com.studyisnthard.SIH.entity;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
public class Question {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    Test test;

    String question_text;
    String correct_answer;

    public Question(){};

    public Question(Long id, Test test, String question_text, String correct_answer) {
        this.id = id;
        this.test = test;
        this.question_text = question_text;
        this.correct_answer = correct_answer;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public String getQuestion_text() {
        return question_text;
    }

    public void setQuestion_text(String question_text) {
        this.question_text = question_text;
    }

    public String getCorrect_answer() {
        return correct_answer;
    }

    public void setCorrect_answer(String correct_answer) {
        this.correct_answer = correct_answer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

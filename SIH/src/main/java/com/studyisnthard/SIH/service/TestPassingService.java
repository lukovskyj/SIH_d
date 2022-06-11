package com.studyisnthard.SIH.service;

import com.studyisnthard.SIH.DTO.TestCorrectAnswer;
import com.studyisnthard.SIH.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestPassingService {

    @Autowired
    TestService testService;

    public TestCorrectAnswer getTestCorrectAnswer(Long test_id){
        List<Question> questionList = this.testService.getQuestionByTest(test_id);
        TestCorrectAnswer testCorrectAnswer = new TestCorrectAnswer();
        ArrayList<String> correctAnswers = new ArrayList<>();
        for (Question q : questionList){
            correctAnswers.add(q.getCorrect_answer());
        }
        testCorrectAnswer.setCorrect_answer(correctAnswers);
        testCorrectAnswer.setId(test_id);
        return testCorrectAnswer;
        }

}

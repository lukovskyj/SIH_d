package com.studyisnthard.SIH.repos;

import com.studyisnthard.SIH.entity.Question;
import com.studyisnthard.SIH.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByTest(Test test);

    @Transactional
    @Modifying
    @Query("update Question t set t.correct_answer = :correct_answer, t.question_text = :question_text where t.id = :question_id")
    void updateQuestionData(@Param("question_id") Long question_id, @Param("correct_answer") String correct_answer,
                            @Param("question_text") String question_text);

    @Transactional
    @Modifying
    @Query("update Question t set t.question_text = 'test', t.correct_answer='test' where t.id = :question_id")
    void Update(@Param("question_id") Long question_id);

    @Transactional
    void deleteQuestionById(Long id);
}

package com.studyisnthard.SIH.repos;

import com.studyisnthard.SIH.entity.Article;
import com.studyisnthard.SIH.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByUser(User user);

    @Transactional
    void deleteById(Long id);

    @Transactional
    @Modifying
    @Query("update Article t set t.articleData = :articleData, t.articleDesc = :articleDesc, t.articleName = :articleName where t.id = :id")
    void updateTestData(@Param("id") Long id, @Param("articleData") String articleData,
                        @Param("articleDesc") String articleDesc, @Param("articleName") String articleName);
}

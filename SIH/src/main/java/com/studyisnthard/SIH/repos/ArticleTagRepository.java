package com.studyisnthard.SIH.repos;

import com.studyisnthard.SIH.entity.Article;
import com.studyisnthard.SIH.entity.ArticleTag;
import com.studyisnthard.SIH.entity.Test;
import com.studyisnthard.SIH.entity.TestTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface ArticleTagRepository extends JpaRepository<ArticleTag, Long> {
    List<ArticleTag> findByArticle(Article article);

    @Transactional
    @Modifying
    @Query("delete from ArticleTag t where t.article = :article")
    void deleteByArticle(@Param("article") Article article);

}

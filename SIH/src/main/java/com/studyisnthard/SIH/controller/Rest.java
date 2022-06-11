package com.studyisnthard.SIH.controller;

import com.studyisnthard.SIH.DTO.TestCorrectAnswer;
import com.studyisnthard.SIH.entity.Article;
import com.studyisnthard.SIH.entity.Test;
import com.studyisnthard.SIH.entity.User;
import com.studyisnthard.SIH.service.ArticleService;
import com.studyisnthard.SIH.service.TestPassingService;
import com.studyisnthard.SIH.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Rest {

    @Autowired
    TestPassingService testPassingService;

    @Autowired
    ArticleService articleService;

    @Autowired
    TestService testService;

    @GetMapping("/rest")
    public TestCorrectAnswer t(@RequestParam(name = "test_id") Long test_id){
        return this.testPassingService.getTestCorrectAnswer(test_id);
    }

    @PostMapping("/rest")
    public boolean te(@RequestParam String name){
        if (name != null) return true;
        else return false;
    }

    @GetMapping("/rest/t/{id}")
    public Article t2(@PathVariable(name = "id") Long id){
        return this.articleService.getArticleById(id);
    }

    @PostMapping("/rest/t/")
    public void t3(@RequestBody Article article){
        this.articleService.saveArticle(article);
    }

    @GetMapping("/rest/1")
    public List<Test> pastSimple(Model model){
        return this.testService.getTestByTag("PastSimple");
    }
}

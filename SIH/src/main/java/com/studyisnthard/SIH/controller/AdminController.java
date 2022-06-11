package com.studyisnthard.SIH.controller;


import com.studyisnthard.SIH.entity.*;
//import com.studyisnthard.SIH.repos.AchievementsRepository;
import com.studyisnthard.SIH.service.ArticleService;
import com.studyisnthard.SIH.service.TestService;
import com.studyisnthard.SIH.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private TestService testService;
//    @Autowired
//    private AchievementsRepository achievementsRepository;
    @Autowired
    private ArticleService articleService;

    @GetMapping("/admin")
    public String admin(Model model, @AuthenticationPrincipal User user){
        model.addAttribute("test_list", this.testService.getTestByAuthor(user));
        model.addAttribute("article_list", this.articleService.getArticleListByUser(user));
        return "adminPage";
    }

    @GetMapping("/admin/article/create")
    public String createArticlePage(){
        return "adminCreateArticle";
    }


    @GetMapping("/admin/article")
    public String adminArticle(Model model, @AuthenticationPrincipal User user){
        model.addAttribute("article_list", this.articleService.getArticleListByUser(user));
        return "adminTest";
    }


    @PostMapping("/admin/create/article")
    public String adminCreateArticle(
            @RequestParam(name = "a_name") String a_name,
            @RequestParam(name = "a_desc") String a_desc,
            @RequestParam(name = "a_data") String a_data,
            @AuthenticationPrincipal User user
    ){
        this.articleService.saveArticle(new Article(null, a_name, a_desc, a_data, user));
        return "redirect:/admin";
    }

    @PostMapping("/admin/article/delete/{article_id}")
    public String deleteAticleById(
            @PathVariable("article_id") Long article_id){
        this.articleService.deleteArticleById(article_id);
        return "redirect:/admin/article";
    }

    @GetMapping("/admin/article/{article_id}")
    public String adminArticleById(
            @PathVariable("article_id") Long article_id,
            Model model
    ){
        model.addAttribute("article", this.articleService.getArticleById(article_id));
        return "adminTest";
    }

    @PostMapping("/admin/article/update/{article_id}")
    public String updateArticleById(@PathVariable("article_id") Long a_id,
                                 Model model, @RequestParam String a_name,
                                 @RequestParam String a_desc, @RequestParam String a_data){
        this.articleService.updateArticle(a_id, a_data, a_desc, a_name);
        return "redirect:/admin/article";
    }



    @GetMapping("/admin/test")
    public String adminTest(Model model, @AuthenticationPrincipal User user){
        model.addAttribute("test_list", this.testService.getTestByAuthor(user));
        return "adminTest";
    }

    @GetMapping("/admin/test/{test_id}")
    public String adminTestByID(
            @PathVariable("test_id") Long test_id,
            Model model
    ){
        Test test = this.testService.getTestById(test_id);
        List<Question> questionList = this.testService.getQuestionByTest(test_id);
        if (questionList == null){
            model.addAttribute("test_error", "Test error");
        }
        else {
            model.addAttribute("test", this.testService.getTestById(test_id));
            model.addAttribute("question_list", this.testService.getQuestionByTest(test_id));
        }
        return "adminTest";
    }



    @PostMapping("/admin/test/question/insert/{test_id}")
    public String adminAddNewQuestion(Model model, @PathVariable("test_id") Long test_id){
        this.testService.saveDefaultQuestion(test_id);
        Test test = this.testService.getTestById(test_id);
        List<Question> questionList = this.testService.getQuestionByTest(test_id);
        if (questionList == null){
            model.addAttribute("test_error", "Test error");
        }
        else {
            model.addAttribute("test", this.testService.getTestById(test_id));
            model.addAttribute("question_list", this.testService.getQuestionByTest(test_id));
        }
        return "adminTest";
    }

    @PostMapping("/admin/test/question/delete/{question_id}")
    public String adminDeleteQuestion(Model model, @PathVariable("question_id") Long question_id){
        Test test = this.testService.getTestByQuestTestId(question_id);
        this.testService.deleteQuestionById(question_id);
        List<Question> questionList = this.testService.getQuestionByTest(test.getId());
        if (questionList == null){
            model.addAttribute("test_error", "Test error");
        }
        else {
            model.addAttribute("test", test);
            model.addAttribute("question_list", questionList);
        }
        return "adminTest";
    }

    @GetMapping("/admin/test/question/{question_id}")
    public String adminQuestion(@PathVariable("question_id") Long question_id,
                                Model model){
        model.addAttribute("question", this.testService.getQuestionById(question_id));
        model.addAttribute("test", this.testService.getTestByQuestTestId(question_id));
        return "adminQuestionEdit";
    }

    @PostMapping("/admin/test/question/{question_id}")
    public String adminQuestionUpdate(@PathVariable("question_id") Long question_id,
                                Model model, @RequestParam String question_text,
                                      @RequestParam String correct_answer, @AuthenticationPrincipal User user){
        Question question = new Question(question_id, null, question_text, correct_answer);
        if (question.getId() != null){
            this.testService.updateQuestion(question);
            model.addAttribute("test_list", this.testService.getTestByAuthor(user));
            return "adminPage";
        }
        else {
            return "adminQuestionEdit";
        }
    }

    @PostMapping("/admin")
    public String deleteUser(@RequestParam(required = true, defaultValue = "" ) Long userId,
                             @RequestParam(required = true, defaultValue = "" ) String action,
                             Model model){
    if (action.equals("delete")){
        userService.deleteUser(userId);
    }
    return "redirect:/admin";
    }

    @GetMapping("/admin/gt/{userId}")
    public String gtUser(@PathVariable("userId") Long userId, Model model){
        model.addAttribute("allUsers", userService.usergtList(userId));
        return "admin";
    }

    @PostMapping("/admin/test/delete/{test_id}")
    public String deleteTestById(
            @PathVariable("test_id") Long test_id){
        this.testService.deleteTestById(test_id);
        return "redirect:/admin/test";
    }

    @PostMapping("/admin/test/update/{test_id}")
    public String updateTestById(@PathVariable("test_id") Long test_id,
                                 Model model, @RequestParam String test_name,
                                 @RequestParam String test_desc){
        this.testService.updateTest(test_id, test_name, test_desc);
        return "redirect:/admin/test";
    }

    @GetMapping("/admin/ach")
    public String admin_test(){
        return "admintest";
    }

//    @PostMapping("/admin/ach")
//    public String gCh(@RequestParam(name = "achievementsName") String achievementsName,
//            @RequestParam(name = "achievementsDescription") String achievementsDescription){
//        System.out.println("achievementsDescription + " + " + achievementsDescription");
//        Achievements achievements = new Achievements(null, achievementsName, achievementsDescription);
//        achievementsRepository.save(achievements);
//        return "admintest";
//    }

    @GetMapping("/admin/create")
    public String adminCreate(){
        return "adminCreate";
    }

    @PostMapping("/admin/create")
    public String adminCreateTest(
            @RequestParam(name = "test_name") String test_name,
            @RequestParam(name = "test_desc") String test_desc,
            @AuthenticationPrincipal User user
    ){
        this.testService.createNewTest(test_name, test_desc, user);
        return "redirect:/admin";
    }

    @GetMapping("/admin/create/editing")
    public String testEditing(
            @RequestParam int amount, @RequestParam String name, Model model){
        String[] iterator = new String[amount];
        for (int i = 1; i <= amount; i++){
            iterator[i-1] = new String(String.valueOf(i));
        }
        model.addAttribute("iterator", iterator);
        model.addAttribute("name", name);
        return "adminCreateEdit";
    }


}

package com.studyisnthard.SIH.controller;

import com.studyisnthard.SIH.entity.Question;
import com.studyisnthard.SIH.entity.Test;
import com.studyisnthard.SIH.repos.TestRepository;
import com.studyisnthard.SIH.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class GreetingController {

    @Autowired
    private TestService testService;

    @Autowired
    TestRepository testRepository;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }


    @GetMapping("/testing/{test_id}")
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
        return "testing";
    }


    @GetMapping
    public String landingPage(){
        System.out.println("test");

        return "index";
    }


    @GetMapping("/login")
    public String login(Model model){
        return "loginPage";
    }


}

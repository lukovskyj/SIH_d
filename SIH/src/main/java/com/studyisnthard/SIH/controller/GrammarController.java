package com.studyisnthard.SIH.controller;

import com.studyisnthard.SIH.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GrammarController {
    @Autowired
    TestService testService;

    @GetMapping("/граматика")
    public String gremma(){
        return "gremma";
    }

    @GetMapping("/граматика/past_simple")
    public String pastSimple(Model model){
        model.addAttribute("test_list", this.testService.getTestByTag("PastSimple"));
        return "PastSimple";
    }

    @GetMapping("/граматика/future_continuous")
    public String futureContinuous(Model model){
        model.addAttribute("test_list", this.testService.getTestByTag("FutureContinuous"));
        return "futurecontinuous";
    }

    @GetMapping("/граматика/past_continuous")
    public String pastContinuous(Model model){
        model.addAttribute("test_list", this.testService.getTestByTag("PastContinuous"));
        return "pastcontinuous";
    }
}

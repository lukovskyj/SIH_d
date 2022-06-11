package com.studyisnthard.SIH.controller;


import com.studyisnthard.SIH.entity.User;
import com.studyisnthard.SIH.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuPages {

    @Autowired
    TestService testService;

    @GetMapping("/словничок")
    public String slovnyk(@AuthenticationPrincipal User user, Model model){
        return "slovnyk";
    }

    @GetMapping("/читання")
    public String chytania(@AuthenticationPrincipal User user, Model model){
        return "reading";
    }

    @GetMapping("/interesting")
    public String getInteresting(Model model){
        model.addAttribute("test_preview", this.testService.getTestPreview());
        return "interesting";
    }
}

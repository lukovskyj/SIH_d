package com.studyisnthard.SIH.controller;

import com.studyisnthard.SIH.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserProfileController {

    @GetMapping("/profile")
    String userProfile(@AuthenticationPrincipal User user, Model model){
        model.addAttribute("username", user.getUsername());
        return "user_profile";
    }
}

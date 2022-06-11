package com.studyisnthard.SIH.controller;

import com.studyisnthard.SIH.entity.User;
import com.studyisnthard.SIH.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration(Model model){
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") User userForm,
                          Model model){
        if (userForm.isNotNull(userForm)){
            if (!userForm.getPassword().equals(userForm.getPasswordConfirm())){
                model.addAttribute("passwordError", "Паролі не співпадають");
                return "registration";
            }
            if (!userService.saveUser(userForm)){
                model.addAttribute("usernameError", "Користувач з таким ім'ям вже зареєстрований");
                return "registration";
            }
            return "redirect:/";
        }
        else{
            return "registration";
        }
    }
}

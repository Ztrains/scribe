package com.zrich.scribe.controllers;

import com.zrich.scribe.models.User;
import com.zrich.scribe.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
@SuppressWarnings("all")
public class SignupController {

    @Autowired
    UserService userService;
    
    @GetMapping
    public String signupView() {
        return "signup";
    }

    @PostMapping
    public String signup(User usr) {
        userService.save(usr);
        return "redirect:/signin";
    }
    
}

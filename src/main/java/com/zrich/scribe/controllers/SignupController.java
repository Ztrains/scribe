package com.zrich.scribe.controllers;

import com.zrich.scribe.models.User;
import com.zrich.scribe.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String signupView(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping
    public String signup(User user) {
        // TODO: refactor to Optional<User>
        User userExists = userService.findByUsername(user.getUsername());
        if (userExists != null) {
            // TODO: reject/return error if user already exists by that name
        } else {

        }

        userService.save(user);
        return "redirect:/login";
    }
    
}

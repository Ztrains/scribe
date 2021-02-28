package com.zrich.scribe.controllers;

import java.util.Optional;

import com.zrich.scribe.models.User;
import com.zrich.scribe.services.TodoService;
import com.zrich.scribe.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signin")
@SuppressWarnings("all")
public class SigninController {

    @Autowired
    TodoService todoService;

    @Autowired
    UserService userService;
    
    @GetMapping
    public String signinView() {
        return "signin";
    }

    @PostMapping
    public String login(User usr) {
        System.out.println("in post login controller");
        Optional<User> user = userService.findByUsernameAndPassword(usr.getUsername(), usr.getPassword());
        if (user.isPresent()) {
            System.out.println("user " + user.get().getUsername() + " found");
            return "redirect:/scribe";
        }
        else return "redirect:/login?error=true";
    }

}

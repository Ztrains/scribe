package com.zrich.scribe.controllers;

import java.util.List;

import com.zrich.scribe.models.Todo;
import com.zrich.scribe.models.User;
import com.zrich.scribe.services.TodoService;
import com.zrich.scribe.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/scribe")
@SuppressWarnings("all")
public class ScribeController {

    @Autowired
    TodoService todoService;

    @Autowired
    UserService userService;
    
    @GetMapping
    public String scribeView(Model model, Authentication authentication) {
    
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User user = userService.findByUsername(userDetails.getUsername());

        List<Todo> todos = todoService.getTodosByUser(user);


        model.addAttribute("todos", todos);
        
        return "scribe";
    }
}

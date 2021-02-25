package com.zrich.scribe.controllers;

import com.zrich.scribe.services.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/scribe")
@SuppressWarnings("all")
public class HomeController {

    @Autowired
    TodoService todoService;
    
    @GetMapping
    public String scribePage(Model model) {
        model.addAttribute("todos", todoService.getAllTodos());
        return "scribe";
    }
}

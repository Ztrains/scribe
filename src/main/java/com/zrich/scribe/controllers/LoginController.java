package com.zrich.scribe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
@SuppressWarnings("all")
public class LoginController {

    @GetMapping
    public String loginView() {
        return "login";
    }

}

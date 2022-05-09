package com.example.jobhunt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = {"/index", "/"})
    public String showHome(Model model) {
        return "index";
    }

}

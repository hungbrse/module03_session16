package com.example.session16.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("")
    public String home(Model model) {
        String fullName = "vl luon dau cat moi";
        model.addAttribute("fullName", fullName);
        return "home";
    }
}

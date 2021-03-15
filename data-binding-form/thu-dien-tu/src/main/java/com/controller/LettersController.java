package com.controller;

import com.model.Letters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LettersController {
    @GetMapping("/home")
    public String showEmail(Model model){
        model.addAttribute("email", new Letters());
        return "home";
    }

    @PostMapping("/update")
    public String upDate(@ModelAttribute("email") Letters letters,Model model){
        System.out.println(letters.toString());
        model.addAttribute("mess","update success");
        return "home";
    }
}


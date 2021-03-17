package com.tu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ImageController {
    @GetMapping("/home")
    public String home(){
        return "home";
    }
}

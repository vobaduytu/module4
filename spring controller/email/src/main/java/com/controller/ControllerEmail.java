package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class ControllerEmail {
    private static Pattern pattern;
    private Matcher matcher;

    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";


    public ControllerEmail() {
        pattern = Pattern.compile(EMAIL_REGEX);
    }

    @GetMapping("/index")
    public String getIndex(){
        return "index";
    }

    @PostMapping("/validate")
    public String validate(@RequestParam("email") String email, Model model){
       boolean isvalidate =this.validate(email);

         if (!isvalidate){
       model.addAttribute("message", "email is invalid");
       return "index";}
         model.addAttribute("email",email);
         return "success";
    }

    private boolean validate(String email) {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
}

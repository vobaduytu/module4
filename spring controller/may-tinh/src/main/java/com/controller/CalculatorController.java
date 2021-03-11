package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("/index")
    public String showCaculator(){
        return "index";
    }

    @PostMapping("/process")

    public String process(@RequestParam int t1, int t2, String operator, Model model){

        switch (operator){
            case "+":
                model.addAttribute("result", t1 + t2);
                break;
            case "-":
                model.addAttribute("result", t1 - t2);
                break;
            case "*":
                model.addAttribute("result", t1 * t2);
                break;
            case "/":
                if (t2 == 0){
                    model.addAttribute("result","Khong the chia 1 so cho 0");
                }else {
                    model.addAttribute("result", t1 / t2);
                }
                break;
        }
        return "index";
    }
}

package com.modle;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class SandwichController {
    @GetMapping("/index")
    public String showSawnwich(Model model) {
        model.addAttribute("list", new Sandwich());
        return "index";
    }

    @RequestMapping("/home")
    public String dosand(@ModelAttribute Sandwich sandwich, Model model) {
//        System.out.println(sandwich.isLettuce());
        String result = "";
         if (sandwich.isLettuce()){
             result+="Lettuce ";
         }
        if (sandwich.isTomamto()){
            result+="Tomato ";

        }
        if (sandwich.isSprouts()){
            result+="Sprouts ";
        }
        if (sandwich.isMustard()){
            result+="Mustard ";
        }
        model.addAttribute("mess", result);
         if(result.equals("")) {
             model.addAttribute("mess","ban khong chon gi");
        }
        return "home";
    }
}

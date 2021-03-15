package com.controller;

import com.model.Login;
import com.model.User;
import com.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;;

@Controller
public class UserController {
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("login", new Login());
        return "home";
    }


    @PostMapping("/login")
    public String login(@ModelAttribute("login") Login login, Model model) {
        User user = UserService.checkLogin(login);
        if (user != null) {
            model.addAttribute("user", user);
            return "user";
        } else {
            return "error";
        }

    }
}

package com.controller.controller;

import com.controller.service.DictionaryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    DictionaryService dictionaryService = new DictionaryService();

    @GetMapping("/home")
    public String showDictionary() {
        return "home";
    }

    @PostMapping("search")
    public String search(Model model, @RequestParam String engLish) {
        String result = dictionaryService.search(engLish);
        if (result != null) {
            model.addAttribute("engLish", result);
            return "home2";
        } else {
            model.addAttribute("engLish", "not found");
            return "home2";
        }
    }

}

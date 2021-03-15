package com.controller;

import com.model.Myfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class MyUploadController {
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("MyFiled", new Myfile());
        return "home";
    }

    @PostMapping("/uploadFile")
    public String uploadfile(@ModelAttribute("MyFiled")Myfile myfile, Model model) throws IOException {
        MultipartFile multipartFile = myfile.getMultipartFile();
        String fileName = multipartFile.getOriginalFilename();
        File file = new File("D:\\CodeGym\\module4\\data-binding-form\\upload\\file",fileName);
        multipartFile.transferTo(file);

        model.addAttribute("mess","upload thanh cong");
        return "home";
    }


}

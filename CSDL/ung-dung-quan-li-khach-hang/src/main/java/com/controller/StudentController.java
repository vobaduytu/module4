package com.controller;

import com.dao.StudentDAO;
import com.dao.StudentDAOImpl;
import com.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    StudentDAO studentDAO;

    @RequestMapping("/showStudent")
    public String showStudent(Model model){
        List<Student> studentList =studentDAO.loadStudent();
        model.addAttribute("students",studentList);
        return "student-list";
    }
}

package com.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import model.Customer;
import org.springframework.web.bind.annotation.RequestParam;
import service.CustomerService;



@Controller
public class CustomerController {
    CustomerService customerService = new CustomerService();
    @GetMapping("/index")
    public String showCustomerList(Model model) {

        model.addAttribute("cuslist", customerService.selectAll());
        return "index";
    }

    @GetMapping("/showAdd")
    public String showAdd(@ModelAttribute Customer customer){
        return "add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Customer customer){
        customerService.add(customer);
        return "redirect:/index";
    }

    @GetMapping("/showEdit")
    public String showEdit(Model model, @RequestParam int id){
        Customer customer = customerService.findById(id);
        model.addAttribute("customer",customer);
        return "edit";
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute Customer customer){
        customerService.update(customer);
        return "redirect:/index";
    }
    @GetMapping("/delete")
    public String delete( @RequestParam int id){

        customerService.delete(id);

        return "redirect:/index";
    }

}
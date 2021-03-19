package com.tu.controller;

import com.tu.model.Customer;
import com.tu.repository.ProvinceRepository;
import com.tu.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class CustomerController {
   @Autowired
   private CustomerService customerService;
   @Autowired
   private ProvinceRepository provinceRepository;

   @GetMapping("/create")
    public String showAdd(Model model){
       model.addAttribute("cus",new Customer());
       model.addAttribute("provinces", provinceRepository.findAll());
       return "create";
   }
   @PostMapping("/add")
    public String doAdd(@ModelAttribute("cus") Customer customer, RedirectAttributes redirectAttributes){
       customerService.saveCustomer(customer);
       return "redirect:/home";
   }
   @GetMapping("/home")
    public String home(Model model ,@PageableDefault(size = 10) Pageable pageable,@RequestParam("s") Optional<String> s){
       Page<Customer> customers;
       if(s.isPresent()){
           customers = customerService.findAllByFirstNameContaining(s.get(), pageable);
       } else {
          customers = customerService.showAll(pageable);
       }
       model.addAttribute("cus",customers);
       model.addAttribute("provinces", provinceRepository.findAll());
       return "home";
   }
   @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable long id, Model model){
       model.addAttribute("cus", customerService.findById(id));
       model.addAttribute("provinces", provinceRepository.findAll());
       return "edit";
   }
   @PostMapping("/update")
    public String doEdit(@ModelAttribute("cus") Customer customer){
       customerService.saveCustomer(customer);
       return "redirect:/home";
   }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable long id){
       customerService.remove(id);
       return "redirect:/home";
    }
}

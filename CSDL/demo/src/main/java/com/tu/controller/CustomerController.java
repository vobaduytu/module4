package com.tu.controller;

import com.tu.model.Customer;
import com.tu.service.CustomerService;
import com.tu.service.HibernateCustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/show")
    public String show(Model model) {
       model.addAttribute("customers", customerService.selectAll());
        return "show";
    }
   @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model, RedirectAttributes redirect){
       customerService.delete(id);
       model.addAttribute("customers", customerService.selectAll());
//       redirect.addFlashAttribute("success", "Removed customer successfully!");
       return "show";
   }
   @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable int id, Model model){
       model.addAttribute("customer",customerService.findById(id));
    return "showedit";
   }
   @PostMapping("/update")
    public String doUpdate(@ModelAttribute Customer customer,RedirectAttributes redirectAttributes){
       customerService.update(customer);
       redirectAttributes.addFlashAttribute("success","xong");
       return "redirect:/show";
   }
   @GetMapping("/create")
   public String create(Model model) {
       model.addAttribute("customer", new Customer());
       return "/create";
    }
    @PostMapping("/save")
    public String save(Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("success","xong");
        return "redirect:/show";
    }
}

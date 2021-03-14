package com.controller;

import com.model.Customer;
import com.service.CustomerServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {
    CustomerServiceImp customerServiceImp = new CustomerServiceImp();
    @GetMapping("/index")
    public String index(Model model){
        List<Customer> cus = customerServiceImp.findAll();
        model.addAttribute("customers",cus);
        return "index";
    }
    @GetMapping("/customer/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "/create";
    }
    @PostMapping("/customer/save")
    public String save(Customer customer) {
        customer.setId((int)(Math.random() * 10000));
       customerServiceImp.save(customer);
        return "redirect:/index";
    }
    @GetMapping("/customer/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("customer",customerServiceImp.findById(id));
        return "/edit";
    }
    @PostMapping("/customer/update")
    public String update(Customer customer) {
        customerServiceImp.update(customer.getId(), customer);
        return "redirect:/index";
    }
    @GetMapping("/customer/{id}/delete")
    public String delete(@PathVariable int id, Model model,Customer customer, RedirectAttributes redirect) {
        model.addAttribute("customer", customerServiceImp.findById(id));
        customerServiceImp.remove(customer.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/index";

    }
    @GetMapping("/customer/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerServiceImp.findById(id));
        return "view";
    }
}

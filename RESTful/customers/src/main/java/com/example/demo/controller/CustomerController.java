package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "customers")
public class CustomerController {
    @Autowired
    public CustomerService customerService;

    @GetMapping("/")
    public ResponseEntity<List<Customer>> showAll(){
        List<Customer> customers = customerService.findAll();
        if (customers.isEmpty()){
            return new ResponseEntity<List<Customer>>( HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Customer>>( customers, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") long id){
        System.out.println("Fetching Customer with id " + id);
        Optional<Customer> customer = customerService.findById(id);

        if (customer == null){
            System.out.println("Customer with id " + id + " not found");
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<Customer>(customer.get(),HttpStatus.OK);
    }


    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody Customer customer){

        return new ResponseEntity<>(customerService.save(customer),HttpStatus.CREATED);
    }
    @PutMapping("/")
    public ResponseEntity<?> update( @RequestBody Customer customer ){
        Customer currentCustomer = customerService.save(customer);
        if (currentCustomer == null){
            return new ResponseEntity<>(currentCustomer,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(currentCustomer,HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        try {
            customerService.delele(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}

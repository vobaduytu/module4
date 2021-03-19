package com.tu.service;

import com.tu.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CustomerService {
    Page<Customer> showAll(Pageable pageable);

    Optional<Customer> findById(Long id);

    void saveCustomer(Customer customer);

    void remove(Long id);

    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);
}

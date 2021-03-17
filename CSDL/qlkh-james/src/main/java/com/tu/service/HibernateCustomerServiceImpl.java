package com.tu.service;

import com.tu.model.Customer;

import java.util.Collections;
import java.util.List;

public class HibernateCustomerServiceImpl implements CustomerService<Customer>{
    @Override
    public List<Customer> selectAll() {
        return Collections.emptyList();
    }

    @Override
    public Customer findById(int id) {
        return null;
    }

    @Override
    public void add(Customer customer) {

    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void delete(int id) {

    }
}

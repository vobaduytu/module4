package com.tu.service;

import com.tu.model.Customer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HibernateCustomerServiceImpl implements CustomerService<Customer> {
    @Autowired
    SessionFactory sessionFactory;


    @Override
    public List<Customer> selectAll() {
        Session session = sessionFactory.openSession();
        List<Customer> list = session.createQuery("FROM Customer").list();
        for (Customer customer : list) {
            System.out.println(customer);
        }
        session.close();
        return list;
    }

    @Override
    public Customer findById(int id) {
        Session session = sessionFactory.openSession();
        Customer customer = session.load(Customer.class, id);
        System.out.println(customer);
        return customer;
    }



    @Override
    public void update(Customer customer) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(customer);
        session.getTransaction().commit();
    }

    @Override
    public void save(Customer customer) {
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(customer);
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Customer customer = session.load(Customer.class, id);
            session.delete(customer);
            session.getTransaction().commit();
            System.out.println("detete success!");
        } catch (RuntimeException e) {

            e.printStackTrace();
        } finally {

            session.close();
        }
    }
}

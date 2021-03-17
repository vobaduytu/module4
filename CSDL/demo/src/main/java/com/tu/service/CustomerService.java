package com.tu.service;

import java.util.List;

public interface CustomerService<T> {

     List<T> selectAll();

     T findById(int id);



     void update(T t);
     void save(T t);
     void delete(int id);

}

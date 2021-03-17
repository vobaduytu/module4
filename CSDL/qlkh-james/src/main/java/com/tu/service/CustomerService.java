package com.tu.service;

import java.util.List;

public interface CustomerService<T> {
    List<T> selectAll();

    T findById(int id);

    void add(T t);

    void update(T t);

    void delete(int id);


}

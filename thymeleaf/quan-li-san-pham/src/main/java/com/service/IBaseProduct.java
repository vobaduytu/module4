package com.service;

import com.model.Products;

import java.util.List;

public interface IBaseProduct {
    List<Products> findAll();

    void save(Products products);

    Products findById(int id);

    void update(int id, Products products);

    void remove(int id);
}

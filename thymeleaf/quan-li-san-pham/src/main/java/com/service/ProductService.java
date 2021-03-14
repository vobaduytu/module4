package com.service;

import com.model.Products;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IBaseProduct {
    private static Map<Integer, Products> productsMap;
    static {

        productsMap = new HashMap<>();
        productsMap.put(1, new Products(1, "iphone", "phone"));
        productsMap.put(2, new Products(2, "samsum", "phone"));
        productsMap.put(3, new Products(3, "oppo", "phone"));
        productsMap.put(4, new Products(4, "vinfast", "phone"));
        productsMap.put(5, new Products(5, "iphone7", "phone"));
        productsMap.put(6, new Products(6, "bphone", "phone"));
    }



    @Override
    public List<Products> findAll() {
        return new ArrayList<>(productsMap.values());
    }

    @Override
    public void save(Products products) {
           productsMap.put(products.getId(),products);
    }

    @Override
    public Products findById(int id) {
        return productsMap.get(id);
    }

    @Override
    public void update(int id, Products products) {
      productsMap.put(id,products);
    }

    @Override
    public void remove(int id) {
   productsMap.remove(id);
    }
}

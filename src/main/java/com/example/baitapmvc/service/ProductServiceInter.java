package com.example.baitapmvc.service;

import com.example.baitapmvc.model.Product;

import java.util.List;

public interface ProductServiceInter {
    List<Product> findAll();

    Product findById(int id);

    void addProduct(Product product);

    void deleteProduct(int id);

    void editProduct(int id, Product product);
}

package com.example.baitapmvc.service;

import com.example.baitapmvc.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements ProductServiceInter {
    private static Map<Integer, Product> productMap = new HashMap<>();
        static {
            productMap.put(1,new Product(1,"Thuoc ha sot",10000,"Khong co","Traphaco"));
            productMap.put(2,new Product(2,"Thuoc bo gan",20000,"Khong co","Traphaco"));
            productMap.put(3,new Product(3,"Thuoc khang sinh",30000,"Khong co","Traphaco"));
            productMap.put(4,new Product(4,"Thuoc ho",40000,"Khong co","Traphaco"));
            productMap.put(5,new Product(5,"Thuoc khang viem",50000,"Khong co","Traphaco"));
        }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());

    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void addProduct(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public void deleteProduct(int id) {
        productMap.remove(id);
    }

    @Override
    public void editProduct(int id, Product product) {
        productMap.put(id,product);
    }
}

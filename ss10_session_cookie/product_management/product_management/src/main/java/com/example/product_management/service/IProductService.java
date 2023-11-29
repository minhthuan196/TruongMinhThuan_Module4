package com.example.product_management.service;

import com.example.product_management.model.Product;

import java.util.List;
import java.util.Optional;


public interface IProductService {
    List<Product> findAll();

    Product findById(Long id);
}

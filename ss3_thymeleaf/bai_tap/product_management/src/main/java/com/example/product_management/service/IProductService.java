package com.example.product_management.service;

import com.example.product_management.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IProductService {
    List<Product> displayAllProduct();

    Product displayProductById(int id);

    void createProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(int id);

    List<Product> searchProductByName(String name);
}

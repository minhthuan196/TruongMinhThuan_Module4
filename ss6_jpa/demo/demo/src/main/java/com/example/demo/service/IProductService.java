package com.example.demo.service;



import com.example.demo.model.Product;

import java.util.List;


public interface IProductService {
    List<Product> displayAllProduct();

    Product displayProductById(int id);

    void createProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(int id);

    List<Product> searchProductByName(String name);
}

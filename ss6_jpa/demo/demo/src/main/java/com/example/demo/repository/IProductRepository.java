package com.example.demo.repository;


import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Integer> {
    //    List<Product> displayAllProduct();
//
//    Product displayProductById(int id);
//
//    void createProduct(Product product);
//
//    void updateProduct(Product product);
//
//    void deleteProduct(int id);
//
    List<Product> findProductsByNameContaining(String name);
}

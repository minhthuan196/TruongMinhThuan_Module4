package com.example.product_management.repository;

import com.example.product_management.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static final String SELECT_BY_NAME = "select p from Product p where p.name like :name";
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> displayAllProduct() {
        List<Product> productList = new ArrayList<>();
        TypedQuery<Product> query = entityManager.createQuery("select p from Product p", Product.class);
        productList = query.getResultList();
        return productList;
    }

    @Override
    public Product displayProductById(int id) {
        Product product = entityManager.find(Product.class, id);
        return product;
    }

    @Transactional
    @Override
    public void createProduct(Product product) {
        entityManager.persist(product);
    }

    @Transactional
    @Override
    public void updateProduct(Product product) {
        Product productEdit = displayProductById(product.getId());
        productEdit.setName(product.getName());
        productEdit.setPrice(product.getPrice());
        productEdit.setDescription(product.getDescription());
        productEdit.setManufacturer(product.getManufacturer());
        entityManager.merge(productEdit);
    }

    @Transactional
    @Override
    public void deleteProduct(int id) {
        Product product = displayProductById(id);
        entityManager.remove(product);
    }

    @Override
    public List<Product> searchProductByName(String name) {
        List<Product> productList = new ArrayList<>();
        TypedQuery<Product> query = entityManager.createQuery(SELECT_BY_NAME, Product.class);
        query.setParameter("name", "%"+name+"%");
        productList = query.getResultList();
        return productList;
    }
}

package com.example.product_management.repository;

import com.example.product_management.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static final List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Coca", 10000, "Nước ngọt", "Coca"));
        productList.add(new Product(2, "Pepsi", 15000, "Nước ngọt", "Pepsi"));
        productList.add(new Product(3, "Sting", 10000, "Nước ngọt", "Sting"));
        productList.add(new Product(4, "Tiger", 15000, "Beer", "Tiger"));
        productList.add(new Product(5, "Huda", 15000, "Beer", "Huda"));
        productList.add(new Product(6, "Ken", 20000, "Beer", "Ken"));

    }

    @Override
    public List<Product> displayAllProduct() {
        return productList;
    }

    @Override
    public Product displayProductById(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void createProduct(Product product) {
        productList.add(product);
    }

    @Override
    public void updateProduct(Product product) {
        for (Product product1 : productList) {
            if (product.getId() == product1.getId()) {
                product1.setName(product.getName());
                product1.setPrice(product.getPrice());
                product1.setDescription(product.getDescription());
                product1.setManufacturer(product.getManufacturer());
                break;
            }
        }
    }

    @Override
    public void deleteProduct(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                productList.remove(product);
                break;
            }
        }
    }

    @Override
    public List<Product> searchProductByName(String name) {
        List<Product> productList1 = new ArrayList<>();
        for (Product product : productList) {
            if (product.getName().toLowerCase().contains(name.trim().toLowerCase())) {
                productList1.add(product);
            }
        }
        return productList1;
    }
}

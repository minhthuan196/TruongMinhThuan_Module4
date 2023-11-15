package com.example.customermanagement.repository;

import com.example.customermanagement.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAllCustomer();
    Customer getCustomerById(int id);
}

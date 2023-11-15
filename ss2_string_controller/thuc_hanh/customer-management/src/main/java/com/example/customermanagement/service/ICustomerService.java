package com.example.customermanagement.service;

import com.example.customermanagement.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAllCustomer();
    Customer getCustomerById(int id);
    void createCustomer(Customer customer);

    void updateCustomer(Customer customer);

    void deleteCustomer(int id);
}

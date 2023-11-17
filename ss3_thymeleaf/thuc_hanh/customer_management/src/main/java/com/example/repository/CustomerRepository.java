package com.example.repository;

import com.example.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository implements ICustomerRepository {
    private static final List<Customer> customers;

    static {
        customers = new ArrayList<>();
        customers.add(new Customer(1, "John", "john@codegym.vn", "Ha Noi"));
        customers.add(new Customer(2, "Bill", "bill@codegym.vn", "Hai Phong"));
        customers.add(new Customer(3, "Alex", "alex@codegym.vn", "Sai Gon"));
        customers.add(new Customer(4, "Adam", "adam@codegym.vn", "Beijing"));
        customers.add(new Customer(5, "Sophia", "sophia@codegym.vn", "Miami"));
        customers.add(new Customer(6, "Rose", "rose@codegym.vn", "NewYork"));
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public void save(Customer customer) {
        customers.add(customer);
    }

    @Override
    public Customer findById(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public void update(Customer customer) {
        for (Customer customer1 : customers) {
            if (customer.getId() == customer1.getId()) {
                customer1.setName(customer.getName());
                customer1.setAddress(customer.getAddress());
                customer1.setEmail(customer.getEmail());
                break;
            }
        }
    }

    @Override
    public void remove(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                customers.remove(customer);
                break;
            }
        }
    }
}

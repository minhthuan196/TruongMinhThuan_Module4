package com.example.customermanagement.repository;


import com.example.customermanagement.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository implements ICustomerRepository {

    private static List<Customer> customerList = new ArrayList<>();

    static {
        customerList.add(new Customer(1, "Nguyễn Khắc Nhập", "Nhat@gmail.com", "Hà Nội"));
        customerList.add(new Customer(2, "Trương Minh Thuận", "Nhat@gmail.com", "Hà Nội"));
        customerList.add(new Customer(3, "Nguyễn Nhật Nguyên", "Nhat@gmail.com", "Hà Nội"));
        customerList.add(new Customer(4, "Trương Khánh Trung", "Nhat@gmail.com", "Hà Nội"));
        customerList.add(new Customer(5, "Nguyễn Văn B", "Nhat@gmail.com", "Hà Nội"));
    }

    @Override
    public List<Customer> findAllCustomer() {
        return customerList;
    }

    @Override
    public Customer getCustomerById(int id) {
        for (Customer customer : customerList) {
            if (id == customer.getId()) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public void createCustomer(Customer customer) {
        customerList.add(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        for (Customer customer1 : customerList) {
            if (customer1.getId() == customer.getId()) {
                customer1.setName(customer.getName());
                customer1.setEmail(customer.getEmail());
                customer1.setAddress(customer.getAddress());
                break;
            }
        }
    }

    @Override
    public void deleteCustomer(int id) {
        for (Customer customer : customerList) {
            if (customer.getId() == id) {
                customerList.remove(customer);
                break;
            }
        }
    }
}

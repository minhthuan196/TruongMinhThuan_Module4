package com.example.customermanagement.controller;

import com.example.customermanagement.model.Customer;
import com.example.customermanagement.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("/")
    public String show(Model model) {
        List<Customer> customerList = customerService.findAllCustomer();
        model.addAttribute("customerList", customerList);
        return "/list";
    }
    @GetMapping("/detail")
    public String showDetailCustomer(Model model,@RequestParam("id") int id){
        Customer customer = customerService.getCustomerById(id);
        model.addAttribute("customer",customer);
        return "/detail";

    }
}

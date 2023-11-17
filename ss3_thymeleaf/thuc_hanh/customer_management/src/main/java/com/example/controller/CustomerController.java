package com.example.controller;

import com.example.model.Customer;
import com.example.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private  ICustomerService customerService ;

    @GetMapping
    public String index(Model model) {
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customers", customerList);
        return "/customer/list";
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "/customer/create";
    }
    @PostMapping("/save")
    public String save(Customer customer, RedirectAttributes redirectAttributes ) {
        customer.setId((int) (Math.random() * 10000));
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("success", "add customer successfully!");
        return "redirect:/";
    }
    @GetMapping("/edit")
    public String update(@RequestParam int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/customer/update";
    }
    @PostMapping("/update")
    public String update(Customer customer) {
        customerService.update(customer);
        return "redirect:/";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/customer/delete";
    }
    @PostMapping("/delete")
    public String delete(Customer customer, RedirectAttributes redirect) {
        customerService.remove(customer.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/";
    }
    @GetMapping("/view")
    public String view(@RequestParam int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/customer/view";
    }
}

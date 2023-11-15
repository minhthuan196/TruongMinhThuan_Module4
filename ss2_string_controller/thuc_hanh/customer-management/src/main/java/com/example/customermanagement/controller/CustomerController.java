package com.example.customermanagement.controller;

import com.example.customermanagement.model.Customer;
import com.example.customermanagement.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String showDetailCustomer(Model model, @RequestParam("id") int id) {
        Customer customer = customerService.getCustomerById(id);
        model.addAttribute("customer", customer);
        return "/detail";

    }

    @GetMapping("/create")
    public String showFormAdd() {
        return "/create";
    }

    @PostMapping("/create")
    public String createCustomer(RedirectAttributes redirectAttributes,
                                 @RequestParam int id,
                                 @RequestParam String name,
                                 @RequestParam String email,
                                 @RequestParam String address) {
        Customer customer = new Customer(id, name, email, address);
        customerService.createCustomer(customer);
        redirectAttributes.addFlashAttribute("message", "add new customer success");
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String showFormEdit(Model model, @RequestParam int id) {
        Customer customer = customerService.getCustomerById(id);
        model.addAttribute("customer", customer);
        return "/edit";
    }

    @PostMapping("/edit")
    public String updateCustomer(RedirectAttributes redirectAttributes,
                                 @RequestParam int id,
                                 @RequestParam String name,
                                 @RequestParam String email,
                                 @RequestParam String address) {
        Customer customer = new Customer(id, name, email, address);
        customerService.updateCustomer(customer);
        redirectAttributes.addFlashAttribute("message", "Update customer success");
        return "redirect:/";
    }
    @GetMapping("/delete")
    public String deleteCustomer(RedirectAttributes redirectAttributes,
                                 @RequestParam int id){
        customerService.deleteCustomer(id);
        redirectAttributes.addFlashAttribute("message", "Delete customer success");
        return "redirect:/";
    }
}

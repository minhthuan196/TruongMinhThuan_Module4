package com.example.product_management.controller;

import com.example.product_management.model.Product;
import com.example.product_management.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping
    public String showAllProduct(Model model) {
        List<Product> productList = productService.displayAllProduct();
        model.addAttribute("productList", productList);
        return "/product/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("product", new Product());
        return "/product/create";
    }

    @PostMapping("/save")
    public String saveProduct(Product product, RedirectAttributes redirectAttributes) {
        productService.createProduct(product);
        redirectAttributes.addFlashAttribute("success", "add new product success!!!");
        return "redirect:/product";
    }

    @GetMapping("/detail")
    public String detailProduct(@RequestParam int id, Model model) {
        Product product = productService.displayProductById(id);
        model.addAttribute("product", product);
        return "/product/detail";

    }

    @GetMapping("/edit")
    public String showFormEdit(@RequestParam int id, Model model) {
        Product product = productService.displayProductById(id);
        model.addAttribute("product", product);
        return "/product/edit";
    }

    @PostMapping("/update")
    public String updateProduct(RedirectAttributes redirectAttributes, Product product) {
        productService.updateProduct(product);
        redirectAttributes.addFlashAttribute("success", "update product success!!!");
        return "redirect:/product";
    }

//    @GetMapping("/delete")
//    public String showFormDelete(@RequestParam int id, Model model) {
//        Product product = productService.displayProductById(id);
//        model.addAttribute("product", product);
//        return "/product/delete";
//    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam int id, RedirectAttributes redirectAttributes) {
        productService.deleteProduct(id);
        redirectAttributes.addFlashAttribute("success", "Delete product success!!!");
        return "redirect:/product";
    }

    @PostMapping("/search")
    public String search(@RequestParam String name, Model model) {
        List<Product> productList = productService.searchProductByName(name);
        model.addAttribute("productList", productList);
        model.addAttribute("name", name);
        return "/product/list";
    }


}

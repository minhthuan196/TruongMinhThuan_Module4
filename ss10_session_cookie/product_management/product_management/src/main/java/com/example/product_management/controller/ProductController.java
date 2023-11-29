package com.example.product_management.controller;

import com.example.product_management.model.Cart;
import com.example.product_management.model.Product;
import com.example.product_management.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;


@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public String showShop(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "/product/shop";
    }

    @GetMapping("/add")
    public String addToCart(@RequestParam Long id,
                            @ModelAttribute Cart cart,
                            @RequestParam("action") String action,
                            RedirectAttributes redirectAttributes) {
        Product productOptional = productService.findById(id);
        if (productOptional == null) {
            return "/product/error_404";
        }
        if (action.equals("show")) {
            cart.addProduct(productOptional);
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional);
        redirectAttributes.addFlashAttribute("success", "Add to cart successfully");
        return "redirect:/shop";
    }

    @GetMapping("/minus")
    public String minusToCart(@RequestParam Long id,
                              @ModelAttribute Cart cart,
                              @RequestParam("action") String action) {
        Product productOptional = productService.findById(id);
        if (productOptional == null) {
            return "/product/error_404";
        }
        cart.minusProduct(productOptional);
        return "redirect:/shopping-cart";
    }

    @GetMapping("detail")
    public String detailProduct(@RequestParam Long id, Model model) {
        Product product = productService.findById(id);
        if (product == null) {
            return "/product/error_404";
        }
        model.addAttribute("product", product);
        return "/product/detail";
    }

    @GetMapping("delete")
    public String deleteProduct(RedirectAttributes redirectAttributes, @RequestParam Long id, @ModelAttribute Cart cart) {
        Product product = productService.findById(id);
        if (product == null) {
            return "/product/error_404";
        }
        redirectAttributes.addFlashAttribute("success", "Delete product success");
        cart.deleteProduct(product);
        return "redirect:/shopping-cart";
    }
}

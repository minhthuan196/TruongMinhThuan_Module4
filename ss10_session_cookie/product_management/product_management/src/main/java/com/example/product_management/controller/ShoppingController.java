package com.example.product_management.controller;

import com.example.product_management.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class ShoppingController {
    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shopping-cart")
    public String showCart(@SessionAttribute("cart") Cart cart, Model model) {
        model.addAttribute("cart", cart);
        return "/product/cart";
    }
}

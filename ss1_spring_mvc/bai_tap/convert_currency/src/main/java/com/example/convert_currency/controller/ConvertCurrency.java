package com.example.convert_currency.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertCurrency {

    @GetMapping("/")
    public String convertCurrency(Model model) {
        return "/input";
    }

    @PostMapping("/convert")
    public String showResult(Model model,
                             @RequestParam int usd,
                             @RequestParam int rate) {
        int result = usd * rate;
        model.addAttribute("result", result);
        model.addAttribute("usd", usd);
        model.addAttribute("rate", rate);
        return "/result";
    }

}

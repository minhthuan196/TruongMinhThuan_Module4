package com.example.translate_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class Translate {
    private static Map<String, String> map = new HashMap<>();

    static {
        map.put("banana", "chuối");
        map.put("apple", "táo");
        map.put("orange ", "cam");
        map.put("mango", "xoài");
        map.put("guava", "ổi");
        map.put("dragon fruit", "thanh long");
    }

    @GetMapping("/")
    public String translate(Model model) {
        String result = "";
        model.addAttribute("result", result);
        return "/home";
    }

    @PostMapping("/translate")
    public String translate(Model model, @RequestParam String input) {
        String result;
        input = input.toLowerCase().trim();
        result = map.get(input);
        model.addAttribute("result", result);
        return "/home";
    }
}

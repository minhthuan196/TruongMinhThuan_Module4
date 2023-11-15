package com.example.project_default_jsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CalculatorController {
    @GetMapping("/")
    public String showHome(Model model) {
        return "/list";
    }

    @PostMapping("/calculator")
    public String showHome(RedirectAttributes redirectAttributes,
                           @RequestParam int number1,
                           @RequestParam int number2,
                           @RequestParam String calculator) {
        int result = 0;
        switch (calculator) {
            case "addition":
                result = number1 + number2;
                break;
            case "subtraction":
                result = number1 - number2;
                break;
            case "multiplication":
                result = number1 * number2;
                break;
            case "division":
                try {
                    result = number1 / number2;
                } catch (ArithmeticException e) {
                    e.getMessage();
                }
                break;
        }
        redirectAttributes.addFlashAttribute("result", result);
        return "redirect:/";
    }
}

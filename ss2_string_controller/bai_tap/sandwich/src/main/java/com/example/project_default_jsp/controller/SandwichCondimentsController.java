package com.example.project_default_jsp.controller;

import com.example.project_default_jsp.model.SandwichCondiments;
import com.example.project_default_jsp.service.ISandwichCondimentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class SandwichCondimentsController {
    @Autowired
    private ISandwichCondimentsService sandwichCondimentsService;

    @GetMapping("/")
    public String showAll(Model model) {
        List<SandwichCondiments> sandwichCondimentsList = sandwichCondimentsService.displayAll();
        model.addAttribute("sandwichCondimentsList", sandwichCondimentsList);
        return "/list";
    }

    @PostMapping("/save")
    public String save(RedirectAttributes redirectAttributes,
                       @RequestParam String[] condiment) {

        redirectAttributes.addFlashAttribute("condiment", condiment);
        return "redirect:/";
    }
}

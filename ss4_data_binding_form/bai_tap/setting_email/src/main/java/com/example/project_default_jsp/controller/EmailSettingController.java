package com.example.project_default_jsp.controller;

import com.example.project_default_jsp.model.EmailSetting;
import com.example.project_default_jsp.service.IEmailSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class EmailSettingController {
    @Autowired
    private IEmailSettingService emailSettingService;

    @GetMapping("/")
    public String showEmailSetting(Model model) {
        EmailSetting emailSetting = emailSettingService.displayEmailSetting();
        List<String> languages = emailSettingService.displayAllLanguages();
        List<Integer> pageSize = emailSettingService.displayAllPageSize();
        model.addAttribute("emailSetting", emailSetting);
        model.addAttribute("languages", languages);
        model.addAttribute("pageSize", pageSize);
        return "/home";
    }

    @PostMapping("/result")
    public String result(@ModelAttribute EmailSetting emailSetting, Model model) {
        emailSettingService.updateEmailSetting(emailSetting);
        model.addAttribute("emailSetting", emailSetting);
        return "/result";
    }
}

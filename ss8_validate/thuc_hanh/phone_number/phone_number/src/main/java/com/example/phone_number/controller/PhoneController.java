package com.example.phone_number.controller;

import com.example.phone_number.dto.PhoneDto;
import com.example.phone_number.model.Phone;
import com.fasterxml.jackson.databind.util.BeanUtil;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PhoneController {
    @GetMapping("/phone")
    public String showForm(Model model) {
        model.addAttribute("phoneDto", new PhoneDto());
        return "/phone/index";
    }

    @PostMapping("/phone")
    public String checkValidation(@Valid @ModelAttribute("phoneDto") PhoneDto phoneDto,
                                  BindingResult bindingResult, Model model) {
        new PhoneDto().validate(phoneDto, bindingResult);
        Phone phone = new Phone();
        if (bindingResult.hasFieldErrors()) {
            return "/phone/index";
        } else {
            BeanUtils.copyProperties(phoneDto,phone);
            model.addAttribute("phoneNumber", phone);
            return "/phone/result";
        }
    }
}

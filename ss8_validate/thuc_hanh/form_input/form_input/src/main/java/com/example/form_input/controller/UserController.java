package com.example.form_input.controller;

import com.example.form_input.dto.UserDto;
import com.example.form_input.model.User;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.util.BeanUtil;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @GetMapping("/user")
    public String showForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "/user/index";
    }

    @PostMapping("/validateUser")
    public String checkValidation(@Valid UserDto userDto,
                                  BindingResult bindingResult) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        if (bindingResult.hasFieldErrors()) {
            return "/user/index";
        }
        return "/user/result";
    }
}
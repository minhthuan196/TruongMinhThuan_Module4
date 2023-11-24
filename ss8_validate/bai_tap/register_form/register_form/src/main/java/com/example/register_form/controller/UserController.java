package com.example.register_form.controller;

import com.example.register_form.dto.UserDto;
import com.example.register_form.model.User;
import com.example.register_form.service.IUserService;
import com.fasterxml.jackson.databind.util.BeanUtil;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping
    public String showForm(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "/register/form";
    }

    @PostMapping("/save")
    public String save(@Valid  UserDto userDto, BindingResult bindingResult,Model model) {
        User user = new User();
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/register/form";
        }
        BeanUtils.copyProperties(userDto, user);
        userService.saveUser(user);
        model.addAttribute("name", user.getFirstName() + user.getLastName());
        return "/register/result";
    }
}

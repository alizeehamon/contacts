package com.projet.contacts.controller;


import com.projet.contacts.dto.UserDTO;
import com.projet.contacts.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String displayRegisterForm(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid UserDTO userDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("userDTO", userDTO);
            return "register";
        } else {
            userService.register(userDTO);
            return "redirect:/login";
        }
    }

    @GetMapping("/login")
    public String displayLoginForm() {
        return "login";
    }
}

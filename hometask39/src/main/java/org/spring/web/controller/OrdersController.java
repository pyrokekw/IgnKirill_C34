package org.spring.web.controller;

import org.spring.web.model.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/shop")
public class OrdersController {

    @GetMapping("/orders")
    public String showForm(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "orders";
    }

    @PostMapping("/orders")
    public String submitForm(
            @Valid @ModelAttribute("userForm") UserForm userForm,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "orders";
        }

        model.addAttribute("message", "Success!");
        return "success";
    }
}
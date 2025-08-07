package org.spring.web.controller;

import org.spring.web.model.UserForm;
import org.spring.web.exc.UserProcessingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping("/create")
    public String showForm(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "user-form";
    }

    @PostMapping("/create")
    public String processForm(
            @ModelAttribute("userForm") UserForm form) {

        if ("erroruser".equalsIgnoreCase(form.getUsername())) {
            throw new UserProcessingException("user.error.processing");
        }

        return "redirect:/users/success";
    }
}
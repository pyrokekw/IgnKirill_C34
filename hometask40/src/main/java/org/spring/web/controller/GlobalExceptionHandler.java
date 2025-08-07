package org.spring.web.controller;

import org.spring.web.exc.UserProcessingException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserProcessingException.class)
    public String handleUserException(UserProcessingException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "error";
    }
}
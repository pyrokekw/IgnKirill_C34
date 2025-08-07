package org.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shop")
public class OrdersController {

    @PostMapping( "/orders")
    public String getOrders() {
        return "orders";
    }
}
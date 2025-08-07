package com.example.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SomeController {

    @Value("${my.text:error}")
    private String exampleString;

    @GetMapping("/test")
    public String test() {
        System.out.println("example string: " + exampleString);
        return "null";
    }
}
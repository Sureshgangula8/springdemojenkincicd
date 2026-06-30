package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greetingdemo")
public class GreetingController {

    @GetMapping
    public String greet(@RequestParam(defaultValue = "World") String name) {
        return "Hello, " + name + "!";
    }
}

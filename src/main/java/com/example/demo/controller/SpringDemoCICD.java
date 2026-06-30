package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testcicd")
public class SpringDemoCICD {


	@GetMapping
	public String demo() {
		return "Welcome to Spring boot demo for CI / CD --- Jenkin.";
	}

	@GetMapping("/greeting/{name}")
	public String greetingdemo(@PathVariable String name) {
		name = name.split(" ")[0];
		return "Welcome to Spring boot demo for CI / CD --- Jenkin."+ name;
	}
}

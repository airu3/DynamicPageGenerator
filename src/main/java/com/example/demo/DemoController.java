package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	@GetMapping("/")
	String home() {
		return "Hello Spring Boot!";
	}
	
	@GetMapping("/test")
	String test() {
		return "Hello test world!";
	}
}
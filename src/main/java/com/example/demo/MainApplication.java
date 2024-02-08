package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class MainApplication {
	@GetMapping("/")
	public String index() {
		return "index.html";
	}

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
}

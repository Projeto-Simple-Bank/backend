package com.avanade.simple_bank.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@GetMapping("/")
	public String inicio() {	
		return "API do SimpleBank";
	}
}

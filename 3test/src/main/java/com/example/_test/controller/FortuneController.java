package com.example._test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FortuneController {
	
	@GetMapping("/fortuneToday")
	public String Fortune() {
		return null;
	}
}

package com.example._test.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	//최상위 경로 요청에 대해서 응답할 컨트롤러 메소드 
	@GetMapping("/")
	public String home() {
		
		return "home";
	}
	
	@GetMapping("/boot02/test")
	public String test() {
		return "test";
	}
}














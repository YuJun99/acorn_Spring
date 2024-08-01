package com.example.boot13.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.boot13.dto.CookDto;
import com.example.boot13.service.CookService;

@Controller
public class CookController {
	
	@Autowired CookService service;
	
	@GetMapping("/cook/list")
	public String list(Model model) {
		service.getList(model);
		return "cook/list";
	}
	
	@GetMapping("/cook/insertform")
	public String insertform() {
		
		return "cook/insertform";
	}
	
	@GetMapping("/cook/insert")
	public String insert(CookDto dto) {
		service.insert(dto);
		return "redirect:/cook/list";
	}
	
	@GetMapping("/cook/delete")
	public String delete(Long num) {
		service.delete(num);
		return "redirect:/cook/list";
	}
	
	@GetMapping("/cook/updateform")
	public String updateform(Long num, Model model) {
		service.getData(num, model);
		return "cook/updateform";
	}
	
	@PostMapping("/cook/update")
	public String update(CookDto dto) {
		service.update(dto);
		return "redirect:/cook/list";
	}
}

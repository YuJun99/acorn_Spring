package com.example.boot11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.example.boot11.dto.GalleryDto;
import com.example.boot11.service.GalleryService;

@Controller
public class GalleryController {
	
	@Autowired GalleryService service;
	
	@GetMapping("/gallery/list")
	public String list(Model model, GalleryDto dto) {
		service.getList(model, dto);
		return "gallery/list";
	}
	
	@GetMapping("/gallery/uploadform")
	public String uploadForm() {
		return "gallery/uploadform";
	}
	
	@PostMapping("/gallery/upload")
	public String upload(MultipartFile image, GalleryDto dto) {
		service.saveImage(image, dto);
		return "redirect:/gallery/list";
	}
}

package com.example.boot14.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.boot14.dto.PostDto;
import com.example.boot14.service.PostService;

@RestController
public class PostController {
	
	@Autowired
	private PostService service;
	
	@GetMapping("/posts")
	public List<PostDto> posts(){
		return service.getAll();
	}
}

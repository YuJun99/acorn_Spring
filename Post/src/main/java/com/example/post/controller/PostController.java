package com.example.post.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.post.dao.PostDao;
import com.example.post.dto.PostDto;

@Controller
public class PostController {
	@Autowired
	private PostDao dao;
	
	@GetMapping("/get/posts")
	public String getPosts(Model model) {
		List<PostDto> list = dao.getList();
		model.addAttribute("list", list);
		return list;
	}
	@PostMapping("/post/posts")
	public String postPosts(PostDto dto) {
		
		return null;
	}
}

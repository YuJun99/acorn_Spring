package com.example.post.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.post.dao.PostDao;
import com.example.post.dto.PostDto;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class PostController {
	@Autowired
	private PostDao dao;
	
	@ResponseBody
	@GetMapping("/get")
	public List<PostDto> list(){
		List<PostDto> list = new ArrayList<>();
		List<PostDto> dto = dao.getList();
		for (PostDto tmp : dto) {
			list.add(new PostDto(tmp.getId(), tmp.getTitle(), tmp.getAuthor()));
		}
		
		return list;
	}
	
	@ResponseBody
	@GetMapping("/getData")
	public List<PostDto> list2(int id){
		List<PostDto> list = new ArrayList<>();
		PostDto dto = dao.getData(id);
		list.add(dto);
		
		return list;
	}
	
	
	@ResponseBody
	@PostMapping("/insert")
	public String insert(PostDto dto) {
		dao.insert(dto);
		
		return "redirect:index.html";
	}
}

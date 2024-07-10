package com.example.post.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.post.dao.PostDao;
import com.example.post.dao.PostDaoImpl;
import com.example.post.dto.PostDto;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		return "index.html";
	}
	
	@RequestMapping("/post/list")
	public String list() {
		return "list.jsp";
	}
}

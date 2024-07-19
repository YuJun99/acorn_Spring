package com.example.boot02.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InsertController {
	
	public Map<String, Boolean> insert (String eamil) {
		Map<String, Boolean> map = new HashMap<>();
		return map;
	}
}

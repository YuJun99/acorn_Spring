package com.example.boot10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.boot10.dao.PostDao;
import com.example.boot10.dto.PostDto;

@RestController // @ResponseBody 의 기능이 모든 메소드에 포함된다.
public class PostController {
	//dao 객체를 주입 받아서
	@Autowired private PostDao dao;
	
	@ResponseBody
	@GetMapping("/posts")
	public List<PostDto> getList(){
		//글 전체 목록을 dao 객체를 이용해서 읽어온 다음 리턴
		return dao.getList();
	}
	
//	@ResponseBody
//	@PostMapping("/posts")
//	public PostDto insert(String title, String author) {
//		// @Builder 의 기능을 이용해서 PostDto 객체에 데이터를 담으면서 객체의 참조값 얻어내기
//		PostDto dto =PostDto.builder().title(title).author(author).build();
//		//dao 를 이용해서 dto 에 저장된 정보를 DB 에 저장하기
//		dao.insert(dto);
//		//현재 추가된 정보를 리턴하기
//		return dto;
//	}
	
	@PostMapping("/posts")
	public PostDto insert(PostDto dto) { //title 과 author 가 추출되어서 PostDto 객체에 담긴채로 전달된다.
		//글번호를 미리 얻어낸다
		int id = dao.getSequence();
		//dto 에 글번호를 담는다
		dto.setId(id);
		dao.insert(dto);
		return dto;
	}
	
	@GetMapping("/posts/{id}")
	public PostDto getData(@PathVariable("id") int id) { //경로 변수 @PathVariable
		return dao.getData(id);
	}
	
	@DeleteMapping("/posts/{id}")
	public String delete(@PathVariable("id") int id) {
		//삭제하기 전에 삭제할 글정보를 미리 담아두고
		PostDto dto = dao.getData(id);
		//DB 에서 삭제
		dao.delete(id);
		//삭제된 글정보를 리턴
		return "deleted!";
	}
	
	@PutMapping("/posts/{id}")
	public PostDto update(@PathVariable("id") int id, PostDto dto) {
		//PostDto 에 경로 변수로 넘어오는 수저알 글번호도 담아서 
		dto.setId(id);
		//수정 반영하고
		dao.update(dto);
		//수정된 데이터를 리턴해준다
		return dto;
	}
}

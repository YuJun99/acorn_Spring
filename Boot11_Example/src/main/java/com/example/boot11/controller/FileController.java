package com.example.boot11.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.boot11.dto.FileDto;
import com.example.boot11.repository.FileDao;
import com.example.boot11.service.FileService;

@Controller
public class FileController {
	
	@Autowired private FileService service;
	
	@GetMapping("/file/upload_form")
	public String upload(FileDto dto) {
		return "file/upload_form";
	}
	
	@PostMapping("/file/upload")
	public String upload_form(String title, String writer, MultipartFile myFile, Authentication authentication) {
		
		service.FileUpload(title, writer, myFile, authentication);
		return "file/upload";
	}
	
	@GetMapping("/file/list")
	public String list(Model model) {
		//서비스 객체에 Model 의 참조값을 전달해서 파일 목록이 Model 객체에 담기도록 한다.
		service.getInfo(model);
		// template 페이지에서 파일 목록 응답하기
		return "file/list";
	}
	
	@GetMapping("/file/download")
	public ResponseEntity<InputStreamResource> download(int num) throws UnsupportedEncodingException, FileNotFoundException{
		
		return service.FileDownload(num);
	}
	
	@GetMapping("/file/delete")
	public String delete(int num) {
		return service.FileDelete(num);
	}
}

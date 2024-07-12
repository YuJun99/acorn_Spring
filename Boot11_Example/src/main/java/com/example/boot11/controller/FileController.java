package com.example.boot11.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.boot11.dto.FileDto;
import com.example.boot11.repository.FileDao;

@Controller
public class FileController {
	
	@Autowired private FileDao dao;
	
	/*
	 *  custom.properties 파일에 있는 파일 업로드
	 *  경로를 읽어와서 필드에 담는다
	 */
	@Value("${file.location}")
	private String fileLocation;
	
	@GetMapping("/file/upload_form")
	public String upload(FileDto dto) {
		return "file/upload_form";
	}
	
	@PostMapping("/file/upload")
	public String upload_form(String title, String writer, MultipartFile myFile, Authentication authentication) {
		FileDto dto = new FileDto();
		String orgFileName = myFile.getOriginalFilename();
		long fileSize = myFile.getSize();
		writer = authentication.getName();
		String saveFileName = UUID.randomUUID().toString();
		String filePath = fileLocation + File.separator + saveFileName;
		try {
			File dest = new File(filePath);
			myFile.transferTo(dest);
		}catch(Exception e) {
			e.printStackTrace();
		}
		dto.setTitle(title);
		dto.setWriter(writer);
		dto.setOrgFileName(orgFileName);
		dto.setSaveFileName(saveFileName);
		dto.setFileSize(fileSize);
		dao.upload(dto);
		
		return "file/upload";
	}
	
	@GetMapping("/file/list")
	public String list(Model model) {
		List<FileDto> list = dao.getList();
		model.addAttribute("list", list);
		return "file/list";
	}
}

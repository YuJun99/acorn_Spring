package com.example.boot11.service;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
	public void getInfo(Model model); //파일 목록을 Model 객체에 담아주는 메소드
	public void FileUpload(String title, String writer, MultipartFile myFile, Authentication authentication); // 파일 정보를 저장하는 메소드
	public ResponseEntity<InputStreamResource> FileDownload(int num) throws UnsupportedEncodingException, FileNotFoundException;
	public String FileDelete(int num);
}

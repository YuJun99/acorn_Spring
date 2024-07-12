package com.example.boot11.service;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
	public void getInfo(Model model);
	public void FileUpload(String title, String writer, MultipartFile myFile, Authentication authentication);
	public ResponseEntity<InputStreamResource> FileDownload(int num) throws UnsupportedEncodingException, FileNotFoundException;
	public String FileDelete(int num);
}

package com.example.boot11.service;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.example.boot11.dto.GalleryDto;

public interface GalleryService {
	public void getList(Model model, GalleryDto dto);
	public void saveImage(MultipartFile image, GalleryDto dto);
	public void getData(int num, Model model);
	public void deleteImage(int num);
	public void updateImage(MultipartFile image, GalleryDto dto);
}

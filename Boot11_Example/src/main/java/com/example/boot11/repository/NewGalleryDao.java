package com.example.boot11.repository;

import java.util.List;

import com.example.boot11.dto.NewGalleryDto;

public interface NewGalleryDao {
	public void insert(NewGalleryDto dto);
	public NewGalleryDto getData(int num);
	public int getCount();
	public List<NewGalleryDto> getList(NewGalleryDto dto);
	public void delete(int num);
}

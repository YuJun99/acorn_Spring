package com.example.boot11.repository;

import java.util.List;

import com.example.boot11.dto.FileDto;

public interface FileDao {
	public List<FileDto> getList();
	public void insert(FileDto dto);
	public FileDto getData(int num);
	public void delete(int num);
}

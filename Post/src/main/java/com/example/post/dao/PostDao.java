package com.example.post.dao;

import java.util.List;

import com.example.post.dto.PostDto;

public interface PostDao {
	public List<PostDto> getList();
	public PostDto getData(int id);
	public void insert (PostDto dto);
}

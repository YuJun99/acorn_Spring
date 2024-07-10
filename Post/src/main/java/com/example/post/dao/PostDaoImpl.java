package com.example.post.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.post.dto.PostDto;

@Repository
public class PostDaoImpl implements PostDao{
	
	@Autowired
	private SqlSession session;

	@Override
	public List<PostDto> getList() {
		List<PostDto> list = session.selectList("post.getList");
		return list;
	}

	@Override
	public void insert(PostDto dto) {
		session.insert("post.insert", dto);
		
	}

	@Override
	public PostDto getData(int id) {
		PostDto dto = session.selectOne("post.getData", id);
		
		return dto;
	}
	
	
}

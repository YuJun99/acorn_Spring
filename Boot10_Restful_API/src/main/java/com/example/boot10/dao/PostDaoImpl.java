package com.example.boot10.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.boot10.dto.PostDto;

//dao 를 bean 으로 만들기 위한 어노테이션
@Repository
public class PostDaoImpl implements PostDao{
	
	// mybatis 기반으로 select, insert, update, delete 작업을 하기 위한 핵심 의존객체 DI
	@Autowired
	private SqlSession session;
	
	@Override
	public List<PostDto> getList() {
		/*
		 * mapper's namespace : post
		 * sql's id : getList
		 * resultType : Postdto
		 * parameterType : 없다.
		 */
		return session.selectList("post.getList");
	}

	@Override
	public PostDto getData(int id) {
		/*
		 * mapper's namespace : post
		 * sql's id : getData
		 * resultType : PostDto
		 * parameterType : int
		 */
		
		return session.selectOne("post.getData", id);
	}

	@Override
	public void insert(PostDto dto) {
		/*
		 * mapper's namespace : post
		 * sql's id : insert
		 * resultType : select 가 아니기 때문에 resultType 은 없다.
		 * parameterType : PostDto
		 */
		
		session.insert("post.insert", dto);
		
	}

	@Override
	public void update(PostDto dto) {
		/*
		 * mapper's namespace : post
		 * sql's id : update
		 * resultType : select 가 아니기 때문에 resultType 은 없다.
		 * parameterType : PostDto
		 */
		session.update("post.update", dto);
		
	}

	@Override
	public void delete(int id) {
		/*
		 * mapper's namespace : post
		 * sql's id : delete
		 * resultType : select 가 아니기 때문에 resultType 은 없다.
		 * parameterType : int
		 */
		session.delete("post.delete", id);
		
	}

	@Override
	public int getSequence() {
		/*
		 * mapper's namespace : post
		 * sql's id : getSequence
		 * resultType : int
		 * parameterType : 없다.
		 */
		return session.selectOne("post.getSequence");
	}
	
}

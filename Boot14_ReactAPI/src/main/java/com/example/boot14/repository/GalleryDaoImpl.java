package com.example.boot14.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.boot14.dto.GalleryDto;

@Repository
public class GalleryDaoImpl implements GalleryDao{

	@Autowired private SqlSession session;
	//갤러리 정보 추가
	@Override
	public void insert(GalleryDto dto) {
		
		session.insert("newgallery.insert", dto);
	}
	//갤러리 하나의 정보 리턴
	@Override
	public GalleryDto getData(int num) {
		
		return session.selectOne("newgallery.getData", num);
	}
	//전체 갤러리의 갯수 리턴
	@Override
	public int getCount() {
		
		return session.selectOne("newgallery.getCount");
	}
	//페이징 처리를 고려한 갤러리 목록 리턴
	@Override
	public List<GalleryDto> getList(GalleryDto dto) {
		
		return session.selectList("newgallery.getList", dto);
	}
	//갤러리 정보 삭제
	@Override
	public void delete(int num) {
		
		session.delete("newgallery.delete", num);
	}
	
}

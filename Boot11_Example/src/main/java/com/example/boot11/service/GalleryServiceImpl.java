package com.example.boot11.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.example.boot11.dto.GalleryDto;
import com.example.boot11.exception.NotOwnerException;
import com.example.boot11.repository.GalleryDao;

@Service
public class GalleryServiceImpl implements GalleryService{

	@Autowired private GalleryDao dao;
	
	//파일을 저장할 위치
	@Value("${file.location}")
	private String fileLocation;
	
	@Override
	public void saveImage(MultipartFile image, GalleryDto dto) {
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		//저장할 파일의 이름 겹치지 않는 유일한 문자열로 얻어내기
		String saveFileName=UUID.randomUUID().toString();
		//파일 전체 경로
		String filePath = fileLocation + File.separator + saveFileName + ".jpg";
		try {
			//업로드된 파일을 이동시킬 목적지 File 객체
			File f=new File(filePath);
			//MultipartFile 객체의 메소드를 통해서 실제로 이동시키기(전송하기)
			image.transferTo(f);
		}catch(Exception e) {
			e.printStackTrace();
		}
		dto.setSaveFileName(saveFileName);
		dto.setWriter(userName);
		dao.insert(dto);
	}

	@Override
	public void getList(Model model, GalleryDto dto) {

		List<GalleryDto> list = dao.getList(dto);
		String filePath = "/editor/images/";
		model.addAttribute("list", list);
		model.addAttribute("filePath", filePath);
	}

	@Override
	public void getData(int num, Model model) {
		
		GalleryDto dto = dao.getData(num);
		String filePath = "/editor/images/";
		model.addAttribute("dto", dto);
		model.addAttribute("filePath", filePath);
	}

	@Override
	public void deleteImage(int num) {
		String writer = dao.getData(num).getWriter();
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		if(!writer.equals(userName)) {
			throw new NotOwnerException("사용자가 일치하지 않습니다.");
		}else {
		dao.delete(num);
		}
	}

	@Override
	public void updateImage(MultipartFile image, GalleryDto dto) {
		String writer = dao.getData(dto.getNum()).getWriter();
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		
		if(!writer.equals(userName)) {
			throw new NotOwnerException("사용자가 일치하지 않습니다.");
		}else {
			
			String saveFileName=UUID.randomUUID().toString();
			
			String filePath = fileLocation + File.separator + saveFileName + ".jpg";
			try {
				//업로드된 파일을 이동시킬 목적지 File 객체
				File f=new File(filePath);
				//MultipartFile 객체의 메소드를 통해서 실제로 이동시키기(전송하기)
				image.transferTo(f);
			}catch(Exception e) {
				e.printStackTrace();
			}
			dto.setSaveFileName(saveFileName);
			dao.update(dto);
		}
		
	}

}

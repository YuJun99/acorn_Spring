package com.example.boot11.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.example.boot11.dto.FileDto;
import com.example.boot11.repository.FileDao;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class FileServiceImpl implements FileService{

	@Autowired private FileDao dao;
	/*
	 *  custom.properties 파일에 있는 파일 업로드
	 *  경로를 읽어와서 필드에 담는다
	 */
	@Value("${file.location}")
	private String fileLocation;
	
	@Override
	public void FileUpload(String title, String writer, MultipartFile myFile, Authentication authentication) {
		FileDto dto = new FileDto();
		String orgFileName = myFile.getOriginalFilename();
		long fileSize = myFile.getSize();
		writer = authentication.getName();
		String saveFileName = UUID.randomUUID().toString();
		String filePath = fileLocation + File.separator + saveFileName;
		try {
			File dest = new File(filePath);
			myFile.transferTo(dest);
		}catch(Exception e) {
			e.printStackTrace();
		}
		dto.setTitle(title);
		dto.setWriter(writer);
		dto.setOrgFileName(orgFileName);
		dto.setSaveFileName(saveFileName);
		dto.setFileSize(fileSize);
		dao.insert(dto);
		
	}

	@Override
	public void getInfo(Model model) {
		List<FileDto> list = dao.getList();
		model.addAttribute("list", list);
	}

	@Override
	public ResponseEntity<InputStreamResource> FileDownload(int num)
			throws UnsupportedEncodingException, FileNotFoundException {
		FileDto dto = dao.getData(num);
		
		String encodeName = URLEncoder.encode(dto.getOrgFileName(), "utf-8");
		encodeName = encodeName.replace("\\+", " ");
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, "application/octet-stream");
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename="+encodeName);
		headers.setContentLength(dto.getFileSize());
		
		String filePath= fileLocation + File.separator + dto.getSaveFileName();
		InputStream is = new FileInputStream(filePath);
		InputStreamResource isr=new InputStreamResource(is);
		ResponseEntity<InputStreamResource> resEntity = ResponseEntity.ok()
				.headers(headers)
				.body(isr);
		return resEntity;
	}

	@Override
	public String FileDelete(int num) {
		FileDto dto = dao.getData(num);
		//로그인된 사용자 이름
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		if(!userName.equals(dto.getWriter())){
			throw new AccessDeniedException("해당 권한이 없습니다.");
		}else {
			String filePath = fileLocation + File.separator + dto.getSaveFileName();
			File f = new File(filePath);
			f.delete();
			dao.delete(num);
		}
		return "redirect:/file/list";
	}

}

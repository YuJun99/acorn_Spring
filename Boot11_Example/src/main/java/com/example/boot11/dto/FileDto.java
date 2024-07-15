package com.example.boot11.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Alias("fileDto") // Mapper xml 에서 FileDto type 을 간단히 줄여서 쓸수 있도록 별칭 부여하기
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FileDto {
	private int num;
	private String writer;
	private String title;
	private String orgFileName;
	private String saveFileName;
	private long fileSize;
	private String regdate;
	
	//페이징 처리를 위한 필드
	private int startRowNum;
	private int endRowNum;
}

package com.example.boot11.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * CREATE TABLE board_gallery(
		num NUMBER PRIMARY KEY,
		writer VARCHAR2(100),
		caption VARCHAR2(100), -- 이미지에 대한 설명
		saveFileName VARCHAR2(100), -- 업로드된 이미지의 저장된 이름
		regdate DATE -- 이미지 업로드 날짜
	);
	
	CREATE SEQUENCE board_gallery_seq;
 */

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GalleryDto {
	private int num;
	private String writer;
	private String caption;
	private String saveFileName;
	private String regdate;
	
	
}

package com.example.boot13.dto;


import java.text.SimpleDateFormat;
import java.util.Locale;

import com.example.boot13.entity.Phone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
public class PhoneDto {
	private long id;
	private String name;
	private String company;
	private String regdate;
	private int price;
	
	public static PhoneDto toDto(Phone phone) {
		// Date type 을 이용해서 원하는 문자열 형식을 얻어내기 위한 객체
		SimpleDateFormat format = new SimpleDateFormat("yyyy.mm.dd E a hh:mm:ss", Locale.KOREA);
		//객체를 이용해서 원하는 문자열을 얻어낸다.
		String result = format.format(phone.getRegdate());
		
		return PhoneDto.builder()
				.id(phone.getId())
				.name(phone.getName())
				.company(phone.getCompany())
				.price(phone.getPrice())
				.regdate(result)
				.build();
	}
	
}

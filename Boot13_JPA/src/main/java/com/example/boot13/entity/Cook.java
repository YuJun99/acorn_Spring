package com.example.boot13.entity;

import com.example.boot13.dto.CookDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name="COOK_INFO")
public class Cook {
	@Id // 대표키 설정
	@GeneratedValue(strategy = GenerationType.AUTO) // 번호는 자동
	private Long num;
	private String name;
	private String recipe;
	
	public static Cook toEntity(CookDto dto) {
		return Cook.builder()
				.num(dto.getNum())
				.name(dto.getName())
				.recipe(dto.getRecipe())
				.build();
	}
}

package com.example.boot13.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.example.boot13.entity.Emp;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class EmpDto {
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private String hiredate;
	private double sal;
	private double comm;
	private int deptno;
	
	public static EmpDto toDto(Emp entity) {
		
		// Date type 을 이용해서 원하는 문자열 형식을 얻어내기 위한 객체
		SimpleDateFormat format = new SimpleDateFormat("yyyy.mm.dd E a hh:mm:ss", Locale.KOREA);
		//객체를 이용해서 원하는 문자열을 얻어낸다.
		String result = format.format(entity.getHiredate());
		
//		double comm = 0;
//		if(entity.getComm() != null) comm = entity.getComm();
		
		return EmpDto.builder()
				.empno(entity.getEmpno())
				.ename(entity.getEname())
				.job(entity.getJob())
				.mgr(entity.getMgr()==null ? 0 : entity.getMgr())
				.hiredate(result)
				.sal(entity.getSal())
				.comm(entity.getComm()==null ? 0 : entity.getComm())
				.deptno(entity.getDept().getDeptno())
				.build();
	}
}

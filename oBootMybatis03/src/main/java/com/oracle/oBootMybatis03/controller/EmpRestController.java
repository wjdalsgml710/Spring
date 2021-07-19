package com.oracle.oBootMybatis03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.oBootMybatis03.model.Dept;
import com.oracle.oBootMybatis03.model.SampleVO;
import com.oracle.oBootMybatis03.service.EmpService;

// Controller + Response Body
@RestController
public class EmpRestController {
	@Autowired
	private EmpService es;
	
	@RequestMapping("/hello")
	public SampleVO	hello() {
		System.out.println("EmpRestController Start...");
		SampleVO vo = new SampleVO();
		vo.setFirstName("hello");
		vo.setLastName("연");
		vo.setMno(123);
		return vo;
	}
	
		@RequestMapping("/helloText")
		public String helloText() {
			System.out.println("EmpRestController Start...");
			String hello = "안녕";
			return hello;
		}
		
		@RequestMapping("/sendVO3")
		public List<Dept> sendV03() {
			System.out.println("@RestController sendVO3 START");
			List<Dept> deptList = es.deptSelect();
			return deptList;
		}
}

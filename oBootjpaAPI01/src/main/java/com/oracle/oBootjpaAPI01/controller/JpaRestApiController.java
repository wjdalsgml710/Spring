package com.oracle.oBootjpaAPI01.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.oBootjpaAPI01.domain.Member;
import com.oracle.oBootjpaAPI01.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

// Controller + ResponseBody 
@RestController
// 이것을 사용함으로, 생성자를 자동생성?할 수 있다?
@RequiredArgsConstructor
// 아래의 Autowired를 생략할 수 있는 어노테이션
public class JpaRestApiController {
	private final MemberService memberService;
//	  * 등록 V1: 요청 값으로 Member 엔티티를 직접 받는다.
  //	  * 문제점
  //	  * - 엔티티에 프레젠테이션 계층을 위한 로직이 추가된다.
  //	  * - 엔티티에 API 검증을 위한 로직이 들어간다. (@NotEmpty 등등)
  //	  * - 실무에서는 회원 엔티티를 위한 API가 다양하게 만들어지는데, 한 엔티티에 각각의 API를 위한 모든 요청 요구사항을 담기는 어렵다.
  //	  * - 엔티티가 변경되면 API 스펙이 변한다.

	
//	@Autowired
//	public JpaRestApiController(MemberService memverService) {
//	this.memberService = memverService;
//	}
	
	@GetMapping("/RestApi/v1/members")
	public List<Member> membersV1() {
		System.out.println("JpaRestApiController start...");
		return memberService.getListAllMember();
	}
	
	@GetMapping("/RestApi/v2/members") //보안
	public Result membersV2() {
//		System.out.println("JpaRestApiController members kkk->"+kkk);
		List<Member> findMembers = memberService.getListAllMember();
		List<MemberDto> collect = findMembers.stream()
											.map(m -> new MemberDto(m.getName())) // 맵(map)은 스트림 내 요소들을 하나씩 특정 값으로 변환 
											.collect(Collectors.toList());			// Collect는 Stream의 데이터를 변형 등의 처리를 하고 원하는 자료형으로 변환
		return new Result(collect.size() , collect);
//		return new Result(collect); // 이것을 사용하려면 totCnt을 닫아줘야한다..?
	}
	@Data
	@AllArgsConstructor
	class Result<T> {
		private int totCnt;
		private T data;
	}
	
	@Data
	@AllArgsConstructor
	class MemberDto {
		private String name;
		
//		public MemberDto(String name) {
//			this.name = name;
//		}
	}
}

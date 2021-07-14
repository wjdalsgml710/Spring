package com.oracle.oBootDBConnect.service;

import java.util.List;

import com.oracle.oBootDBConnect.domain.Member;
import com.oracle.oBootDBConnect.repository.MemberRepository;

public class MemberService {
	//DAO
	private final MemberRepository memberRepository;
	
	public MemberService(MemberRepository memberRepository) {
			this.memberRepository = memberRepository;
	} // 생성자주입
		
		// 회원 가입
	public Long join(Member member) {
		memberRepository.save(member);
		return member.getId();
		}
	
		// 전체회원 조회
	public List<Member> findMembers(){
		System.out.println("MemberService findMembers Start...");
		return memberRepository.findAll();
	}
	}

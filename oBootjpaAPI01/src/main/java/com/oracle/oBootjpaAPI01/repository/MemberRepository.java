package com.oracle.oBootjpaAPI01.repository;

import java.util.List;

import com.oracle.oBootjpaAPI01.domain.Member;

public interface MemberRepository {
	List<Member>	findAll();
	Long 			save(Member member);
	Member			findByMember(Long id);
}

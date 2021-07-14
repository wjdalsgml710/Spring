package com.oracle.oBootjpaAPI01;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.oBootjpaAPI01.domain.Member;
import com.oracle.oBootjpaAPI01.repository.MemberRepository;

@SpringBootTest
class OBootjpaApi01ApplicationTests {
	@Autowired
	MemberRepository memberRepository;
	
	@Test
	@Transactional
	@Rollback(false)
	public void testMember() {
		Member member = new Member();
		member.setName("memberTestA");
		Long saveId = memberRepository.save(member);
		Member findMember = memberRepository.findByMember(saveId);

		System.out.println("@SpringBootTest saveId->" + saveId);
		System.out.println("@SpringBootTest findMember.getId()->" + findMember.getId());
		Assertions.assertThat(findMember.getId()).isEqualTo(member.getId()); // 검증 (같은거 확인하는거 사용해보기)
		Assertions.assertThat(findMember.getId()).isEqualTo(10);
		
	}
	
}

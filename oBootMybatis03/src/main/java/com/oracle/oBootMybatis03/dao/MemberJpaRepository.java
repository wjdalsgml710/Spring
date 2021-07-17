package com.oracle.oBootMybatis03.dao;

import java.util.List;
<<<<<<< HEAD
import java.util.Optional;
=======
>>>>>>> 475da6ea5edf476fa5fcbb262e4fd190955cb70b

import com.oracle.oBootMybatis03.domain.Member;

public interface MemberJpaRepository {
	Member 			save(Member member);
	List<Member> 	findAll();
<<<<<<< HEAD
	Optional<Member> findById(Long id);
	void			updateByMember(Member member);
=======
>>>>>>> 475da6ea5edf476fa5fcbb262e4fd190955cb70b
}

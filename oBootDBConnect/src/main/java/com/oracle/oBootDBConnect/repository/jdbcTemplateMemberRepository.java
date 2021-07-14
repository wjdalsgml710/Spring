package com.oracle.oBootDBConnect.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.oracle.oBootDBConnect.domain.Member;

public class jdbcTemplateMemberRepository implements MemberRepository {
	
	private final JdbcTemplate jdbcTemplate;
	public jdbcTemplateMemberRepository(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource); // 이전의 context.xml에서 DB와 연결해서 사용한 것과 같이 properties에 설정해서 동일하게 사용가능
	}
	
	
	@Override
	public Member save(Member member) {
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate); //sql문에서의 insert를 이와같이 사용가능 (더 추가적인 것이 있는지는 찾아보면 될것!)
		jdbcInsert.withTableName("member");
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("id", member.getId());
		parameters.put("name", member.getName());
		jdbcInsert.execute(parameters);
		
		return member;
	}

	@Override
	public List<Member> findAll() { //dao와 같이 사용!
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from member", memberRowMapper());
	}
	private RowMapper<Member> memberRowMapper() {
		// 확장 for 비슷
		return (rs, rowNum) -> {		// rs는 이미 Resultset rs이 이미 선언되어있음, while(rs.next())과 동일하다고 생각하면됨, ->는 람다식!
			Member member = new Member();
			member.setId(rs.getLong("id"));
			member.setName(rs.getString("name"));
			return member;
		};		
	}
	
	

}

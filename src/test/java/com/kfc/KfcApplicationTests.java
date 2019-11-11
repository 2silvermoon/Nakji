package com.kfc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kfc.db.MemberDto;
import com.kfc.repo.MemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KfcApplicationTests {

	@Autowired
	private MemberRepository repo;
	
	@Test
	public void testInsert() {
		MemberDto member = new MemberDto();
		member.setId(3333L);
		member.setAuth("Test");
		member.setEnabled(0);
		member.setAuthority("ROLE_TEST");
		
		repo.save(member);
	}
	
	@Test
	public void ListMember() {
		repo.findAll().forEach(MemberDto -> System.out.println(MemberDto));
	}
}

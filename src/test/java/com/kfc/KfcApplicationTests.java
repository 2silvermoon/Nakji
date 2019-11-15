package com.kfc;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kfc.db.MemberDto;
import com.kfc.repo.MemberRepository;
import com.kfc.service.RegisterService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KfcApplicationTests {

	@Autowired
	private MemberRepository repo;
	
	@Autowired
	private RegisterService service;
	
	@Test
	public void testInsert() {
		MemberDto member = new MemberDto();
		member.setUserId(201413318);
		member.setUserPassword(service.getEncrypt("201413318"));
		member.setUserGender("Female");
		member.setUserMajor("HOS");
		member.setUserEmail("강원도성애자");
		
		repo.save(member);
	}
	
	@Test
	public void testAuth() {
		Optional<MemberDto> member = repo.findById(22222);
		member.get().setAuth(service.getEncrypt("22222"));
		
		repo.save(member.get());
	}
	
	@Test
	public void ListMember() {
		repo.findAll().forEach(MemberDto -> System.out.println(MemberDto));
	}
}

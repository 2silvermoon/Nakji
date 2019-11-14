package com.kfc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kfc.db.MemberDto;
import com.kfc.repo.MemberRepository;

@Service
public class ThymeleafService {
	
	@Autowired
	private MemberRepository repo;
	
	public void register(String sId) {
		System.out.println(sId + "의 암호화 값 등록");
		int id = Integer.parseInt(sId);
		Optional<MemberDto> member = repo.findById(id);
		member.get().setAuth(resultAuth(sId));
		
		System.out.println("Register Save...");
		repo.save(member.get());
		//Integer nResult1 = dao.registerDao(sId);
		//Integer nResult2 = dao.authDao(sId, resultAuth(sId));
		//System.out.println("regist : " + nResult1 + " " + nResult2);
	}
	
	public void deregister(String sId) {
		System.out.println(sId + "의 암호화 값 제거");
		int id = Integer.parseInt(sId);
		Optional<MemberDto> member = repo.findById(id);
		member.get().setAuth(null);
		
		System.out.println("Deregister Save...");
		repo.save(member.get());
		//Integer nResult1 = dao.deregisterDao(sId);
		//Integer nResult2 = dao.authDao(sId, null);
		//System.out.println("deregist : " + nResult1 + " " + nResult2);
	}
	
	public String resultAuth(String id) {
    	return passwordEncoder().encode(id);
    }
    
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

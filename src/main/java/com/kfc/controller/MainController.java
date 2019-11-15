package com.kfc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kfc.db.MemberDto;
import com.kfc.repo.MemberRepository;
import com.kfc.service.RegisterService;

import lombok.extern.java.Log;

@RestController
@Log
public class MainController {
	
	@Autowired
	private MemberRepository repo;
	
	@Autowired
	private RegisterService service;
	
	@RequestMapping(value="/SignIn", method = RequestMethod.POST)
	public Map<String, String> JsonSignIn(@RequestParam("userId") String id,
											@RequestParam("userPassword") String pw) {
		Map <String, String> map = new HashMap<String, String>();
		try {
			int sId = Integer.parseInt(id);
			MemberDto member = repo.findById(sId).get();
			System.out.println("id 접속");
			if (service.getEncrypt(pw).equals(member.getUserPassword())) {
				System.out.println("Login Success " + id + " " + pw);
				map.put("success", "true");
				map.put("userId", id);
				map.put("userGender", member.getUserGender());
				map.put("userMajor", member.getUserMajor());
				map.put("userEmail", member.getUserEmail());
				log.info("SignIn " + id);
			} else
				map.put("success", "false");
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("로그인 실패");
			map.put("success", "false");
		}
		
		return map;
	}
	
	@RequestMapping(value="/SignUp", method = RequestMethod.POST)
	public Map<String, String> JsonSignUp(@RequestParam("userId") String id,
											@RequestParam("userId") String pw,
											@RequestParam("userId") String gd,
											@RequestParam("userId") String mj,
											@RequestParam("userId") String em) {
		Map <String, String> map = new HashMap<String, String>();
		MemberDto member = new MemberDto();
		member.setUserId(Integer.parseInt(id));
		member.setUserPassword(service.getEncrypt(pw));
		member.setUserGender(gd);
		member.setUserMajor(mj);
		member.setUserEmail(em);
		
		repo.save(member);
		map.put("success", "true");
		log.info("SignUp " + id);
		return map;
	}
	
	@RequestMapping(value="/NdefExe", method = RequestMethod.POST)
	public Map<String, String> JsonNFC(@RequestParam("userData") String text) {
		Map <String, String> map = new HashMap<String, String>();
		int id = Integer.parseInt(text);
		try {
			if(service.isAuth(id)) {
				log.info("NFC success " + id);
				map.put("success", "true");
			}
			else {
				log.info("NFC fail " + id);
				System.out.println("Auth 값이 있는지?");
				map.put("success", "false");
			}
		}catch (Exception e) {
			System.out.println("Auth 오류");
			map.put("success", "false");
		}
		return map;
	}
}
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

@RestController
public class MainController {
	
	@Autowired
	private MemberRepository repo;
	
	@Autowired
	private RegisterService service;
	
	@RequestMapping(value="/SignIn")
	public Map<String, String> JsonSignIn(@RequestParam("userId") String id,
											@RequestParam("userPassword") String pw) {
		Map <String, String> map = new HashMap<String, String>();
		System.out.println("로그인 실행");
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
				map.put("userAuth", member.getAuth());
			} else
				map.put("success", "false");
		}catch (Exception e) {
			System.out.println("뭔가 실패");
			e.printStackTrace();
			map.put("success", "false");
		}
		
		return map;
	}
	
	@RequestMapping(value="/SignUp", method = RequestMethod.POST)
	public Map<String, String> JsonSignUp() {
		Map <String, String> map = new HashMap<String, String>();
		
		return map;
	}
	
	@RequestMapping(value="/NdefExe")
	public Map<String, String> JsonNFC(@RequestParam("userData") String text) {
		Map <String, String> map = new HashMap<String, String>();
		int id = Integer.parseInt(text);
		try {
			if(service.isAuth(id))
				map.put("success", "true");
		}catch (Exception e) {
			map.put("success", "false");
		}
		return map;
	}
}
package com.kfc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfc.db.IMemberDao;
import com.kfc.db.Members;
import com.kfc.repo.MemberRepository;

@Controller
public class MainController {
	
	@Autowired
	private MemberRepository repo;
	
	@RequestMapping("/")
    public String main() {
        return "index";
    }
	
	@RequestMapping("/check")
    public String check() {
        return "member/login";
    }
	
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("readTb", repo.findAll());
		return "admin/list";
	}
	
    @RequestMapping("/loginForm")
    public String loginForm() {
    	System.out.println("loginForm");
        return "security/loginForm";
    }
    
    @RequestMapping("/members")
    @ResponseBody
    public Members getRestMembers(Model model) {
    	Members members = new Members();
    	members.addMembers(repo.findAll());
    	System.out.println("members");
    	return members;
    }
    
    @RequestMapping("/test")
    public void test() {
    	final String uri = "http://localhost:8081/members.json";
    	
    }
}
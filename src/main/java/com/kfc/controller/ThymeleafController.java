package com.kfc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfc.db.Members;
import com.kfc.repo.MemberRepository;
import com.kfc.service.ThymeleafService;

@Controller
public class ThymeleafController {
	
	@Autowired
	private ThymeleafService service;
	
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
	
	@RequestMapping("/register")
	public String register(HttpServletRequest request) {
		String sId = request.getParameter("id");
		service.register(sId);
		
		return "";
	}
	
	@RequestMapping("/deregister")
	public String deregister(HttpServletRequest request) {
		String sId = request.getParameter("id");
		service.deregister(sId);
		
		return "";
	}
}
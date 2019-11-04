package com.kfc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfc.db.IMemberDao;
import com.kfc.db.Members;

@Controller
public class MainController {
	
	@Autowired
	private IMemberDao dao;
	
	@RequestMapping("/")
    public String main() {
		//System.out.println("index");
        return "index";
    }
	
	@RequestMapping("/check")
    public String check() {
		//System.out.println("check");
        return "member/login";
    }
	
	@RequestMapping("/list")
	public String list(Model model) {
		//System.out.println("list");
		model.addAttribute("readTb", dao.listDao());
		//System.out.println("listDao");
		return "admin/list";
	}
	
    @RequestMapping("/loginForm")
    public String loginForm() {
    	//System.out.println("loginForm");
        return "security/loginForm";
    }
    
    @RequestMapping("/members")
    @ResponseBody
    public Members getRestMembers(Model model) {
    	Members members = new Members();
    	members.addMembers(dao.listDao());
    	return members;
    }
    
    @RequestMapping("/test")
    public void test() {
    	final String uri = "http://localhost:8081/members.json";
    	
    }
}
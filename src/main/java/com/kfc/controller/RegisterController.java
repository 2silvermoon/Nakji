package com.kfc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kfc.service.RegisterService;

@Controller
public class RegisterController {
	
	@Autowired
	private RegisterService service;
	
	@RequestMapping("/register")
	public String register(HttpServletRequest request) {
		String sId = request.getParameter("id");
		service.register(sId);
		
		return "redirect:list";
	}
	
	@RequestMapping("/deregister")
	public String deregister(HttpServletRequest request) {
		String sId = request.getParameter("id");
		service.deregister(sId);
		
		return "redirect:list";
	}
}
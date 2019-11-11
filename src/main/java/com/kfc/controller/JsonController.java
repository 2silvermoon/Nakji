package com.kfc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfc.db.IMemberDao;
import com.kfc.db.Members;

public class JsonController {
	@Autowired
	IMemberDao dao;
	
	
	@RequestMapping("/members")
	@ResponseBody
	public Members getJson(Model model) {
		Members members = new Members();
		members.addMembers(dao.listDao());
		return members;
	}
}

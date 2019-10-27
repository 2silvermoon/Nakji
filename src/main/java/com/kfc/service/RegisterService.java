package com.kfc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kfc.db.IMemberDao;

@Service
public class RegisterService implements IRegisterService{
	
	@Autowired
	private IMemberDao dao;
	
	@Override
	public void register(String sId) {
		Integer nResult1 = dao.registerDao(sId);
		Integer nResult2 = dao.authDao(sId, resultAuth(sId));
		System.out.println("regist : " + nResult1 + " " + nResult2);
	}
	
	@Override
	public void deregister(String sId) {
		Integer nResult1 = dao.deregisterDao(sId);
		Integer nResult2 = dao.authDao(sId, null);
		System.out.println("deregist : " + nResult1 + " " + nResult2);
	}
    
	@Override
    public String resultAuth(String id) {
    	return passwordEncoder().encode(id);
    }
    
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
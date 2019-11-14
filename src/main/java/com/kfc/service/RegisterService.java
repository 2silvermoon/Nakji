package com.kfc.service;

import java.security.MessageDigest;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfc.db.MemberDto;
import com.kfc.repo.MemberRepository;

@Service
public class RegisterService {
	
	@Autowired
	private MemberRepository repo;
	
	// Auth compare
	public boolean isAuth(int id) {
		Optional<MemberDto> member = repo.findById(id);
		String sId = String.valueOf(id);
		String tempPw = member.get().getAuth();
		try {
			if (getEncrypt(sId).equals(tempPw)) {
				return true;
			}
			return false;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean isUser(int id) {
		try {
			Optional<MemberDto> member = repo.findById(id);
			return false;
		} catch(Exception e) {
			e.printStackTrace();
			return true;
		}
	}
	
	public String getEncrypt(String value) {
		try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(value.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();
 
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
 
            return hexString.toString();
 
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
	}
}
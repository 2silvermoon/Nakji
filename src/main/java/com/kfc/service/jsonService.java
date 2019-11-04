package com.kfc.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kfc.db.Members;

@Service
public class jsonService {
	public void test() {
		final String uri = "http://localhost:8081/members.json";
		RestTemplate restTemplate = new RestTemplate();
		Members result = restTemplate.getForObject(uri, Members.class);
		System.out.println(result);
	}
}

package com.kfc.service;

public interface IRegisterService {
	void register(String id);
	void deregister(String id);
	String resultAuth(String id);
}

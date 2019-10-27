package com.kfc.db;

import lombok.Data;

@Data
public class MemberDto {
	int id;
	String auth;
	int enabled;
	String authority;
}
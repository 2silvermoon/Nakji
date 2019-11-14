package com.kfc.db;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="user")
public class MemberDto {
	
	@Id
	int userId;
	String userPassword;
	String userGender;
	String userMajor;
	String userEmail;
	String auth;
}
package com.kfc.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="member")
public class MemberDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	String auth;
	int enabled;
	String authority;
}
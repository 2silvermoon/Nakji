package com.kfc.db;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Members {
	
	@XmlElement(name="member")
	private List<MemberDto> members = new ArrayList<>();

	public List<MemberDto> getMembers() {
		return members;
	}

	public void setMembers(List<MemberDto> members) {
		this.members = members;
	}
	
	public void addMembers(Collection<MemberDto> members) {
		this.members.addAll(members);
	}
}
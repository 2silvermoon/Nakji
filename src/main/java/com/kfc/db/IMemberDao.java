package com.kfc.db;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IMemberDao {
	List<MemberDto> listDao();
	Integer registerDao(@Param("id") String id);
	Integer deregisterDao(@Param("id") String id);
	Integer authDao(@Param("id") String id, @Param("auth") String auth);
}
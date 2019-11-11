package com.kfc.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kfc.db.MemberDto;

public interface MemberRepository extends CrudRepository<MemberDto, Long>{
	List<MemberDto> findAll();
}

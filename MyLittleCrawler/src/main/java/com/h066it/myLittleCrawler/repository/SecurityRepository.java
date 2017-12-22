package com.h066it.myLittleCrawler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.h066it.myLittleCrawler.dto.MemberDto;

@Repository
public interface SecurityRepository extends JpaRepository<MemberDto, Integer> {
	public MemberDto findById(String Id);
}

package com.h066it.myLittleCrawler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.h066it.myLittleCrawler.dto.MemberDto;

@Repository
public interface HomeRepository extends JpaRepository<MemberDto, Integer> {
	//JpaRepository는 CrudRepository의 손자뻘 인터페이스이다.
	//JpaRepository는 Crud에 비해 게시판 만들기에 용이한 Paging개념과 배치 작업 모드를 지원한다.
}

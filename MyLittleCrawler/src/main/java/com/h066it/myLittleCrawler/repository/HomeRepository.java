package com.h066it.myLittleCrawler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.h066it.myLittleCrawler.dto.MemberDto;

@Repository
public interface HomeRepository extends JpaRepository<MemberDto, Integer> {
	//JpaRepository�� CrudRepository�� ���ڻ� �������̽��̴�.
	//JpaRepository�� Crud�� ���� �Խ��� ����⿡ ������ Paging����� ��ġ �۾� ��带 �����Ѵ�.
}

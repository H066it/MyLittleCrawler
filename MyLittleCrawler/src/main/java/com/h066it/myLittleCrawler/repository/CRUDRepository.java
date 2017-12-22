package com.h066it.myLittleCrawler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.h066it.myLittleCrawler.dto.BoardDto;

@Repository
public interface CRUDRepository extends JpaRepository<BoardDto, Integer>, JpaSpecificationExecutor<BoardDto> {

}

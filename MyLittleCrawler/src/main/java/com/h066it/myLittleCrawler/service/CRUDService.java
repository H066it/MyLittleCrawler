package com.h066it.myLittleCrawler.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.h066it.myLittleCrawler.dto.BoardDto;

public interface CRUDService {
	
	/* ----------- CRUD 관련. ----------- */
	
	public List<BoardDto> findAllOrderByFIdDesc();
	public void viewCount(int fId);
	public boolean udtPwdChk(int fId, String fPassword);
	public boolean delete(int fId, String fPassword);
	
	/* ----------- search 관련. ----------- */
	
	public Page<BoardDto> findAllWithKeyword(Pageable page, String searchType, String keyword);

}

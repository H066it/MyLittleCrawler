package com.h066it.myLittleCrawler.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import com.h066it.myLittleCrawler.config.SearchSpec;
import com.h066it.myLittleCrawler.dto.BoardDto;
import com.h066it.myLittleCrawler.repository.CRUDRepository;
import com.h066it.myLittleCrawler.service.CRUDService;

@Service("CRUDService")
public class CRUDServiceImpl implements CRUDService {

	@Autowired
	private CRUDRepository repository;

	/* ----------- CRUD 관련. ----------- */
	
	@Override
	public List<BoardDto> findAllOrderByFIdDesc() {
		
		return repository.findAll(sortByFIdDesc());
	}
	
	private Sort sortByFIdDesc() {

		return new Sort(Sort.Direction.DESC, "fId");
	}

	@Override
	public void viewCount(int fId) {
		
		BoardDto dto = repository.findOne(fId);
		dto.setFCount(dto.getFCount() + 1);
		repository.save(dto);
	}
	
	@Override
	@Transactional	// 트랜잭션 처리는 이런식.(본 메소드에는 없어도 무관.)
	public boolean udtPwdChk(int fId, String fPassword) {

		BoardDto dto = repository.findOne(fId);
		
		if(dto.getFPassword().equals(fPassword)) {
			System.out.println("수정작업/비밀번호 일치.");
			return true;
		}
		System.out.println("수정작업/비밀번호 불일치.");
		return false;
	}

	@Override
	public boolean delete(int fId, String fPassword) {

		BoardDto dto = repository.findOne(fId);
		
		if(dto.getFPassword().equals(fPassword)) {
			System.out.println("삭제작업/비밀번호 일치.");
			repository.delete(fId);
			System.out.println("삭제완료.");
			return true;
		}
		System.out.println("삭제작업/비밀번호 불일치.");
		return false;
	}

	/* ----------- search 관련. ----------- */
	
	@Override
	public Page<BoardDto> findAllWithKeyword(Pageable page, String searchType, String keyword) {

		Specifications<BoardDto> spec = null;
		
		if (searchType.equals("fTitle")) {
			spec = Specifications.where(SearchSpec.containFTitle(keyword));
		} else if (searchType.equals("fContent")){
			spec = Specifications.where(SearchSpec.containFContent(keyword));
		} else if (searchType.equals("fWriter")){
			spec = Specifications.where(SearchSpec.containFWriter(keyword));
		} else if (searchType.equals("fTitle_fContent")){
			spec = Specifications.where(SearchSpec.containFTitle(keyword)).or(SearchSpec.containFContent(keyword));
		}
		Page<BoardDto> result = repository.findAll(spec, page);
		
		System.out.println("TP : " + result.getTotalPages());	// 0이면 에러
		if(result.getTotalPages() == 0)
			result = null;
		
		return result;
	}

}

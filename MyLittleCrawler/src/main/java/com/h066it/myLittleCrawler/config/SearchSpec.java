package com.h066it.myLittleCrawler.config;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.h066it.myLittleCrawler.dto.BoardDto;

public class SearchSpec {

	public static Specification<BoardDto> containFTitle(final String keyword) {
		return new Specification<BoardDto>() {

			@Override
			public Predicate toPredicate(Root<BoardDto> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				System.out.println("containFTitle : " + keyword);
				if(keyword == null)
					return null;
				return cb.like(root.get("fTitle"), "%" + keyword + "%");
			}
			
		};
	}
	
	public static Specification<BoardDto> containFContent(final String keyword) {
		return new Specification<BoardDto>() {

			@Override
			public Predicate toPredicate(Root<BoardDto> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				System.out.println("containFContent : " + keyword);
				if(keyword == null)
					return null;
				return cb.like(root.get("fContent"), "%" + keyword + "%");
			}
		
		};
	}
	
	public static Specification<BoardDto> containFWriter(final String keyword) {
		return new Specification<BoardDto>() {
			
			@Override
			public Predicate toPredicate(Root<BoardDto> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
				System.out.println("containFWriter : " + keyword);
				if(keyword == null)
					return null;
				return cb.like(root.get("fWriter"), "%" + keyword + "%");
			}
			
		};
	}	
	
}

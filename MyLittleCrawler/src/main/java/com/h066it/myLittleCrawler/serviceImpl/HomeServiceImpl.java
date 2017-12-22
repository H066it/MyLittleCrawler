package com.h066it.myLittleCrawler.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h066it.myLittleCrawler.repository.HomeRepository;
import com.h066it.myLittleCrawler.service.HomeService;

@Service("HomeService")
public class HomeServiceImpl implements HomeService {

	@Autowired
	private HomeRepository repository;
	
}

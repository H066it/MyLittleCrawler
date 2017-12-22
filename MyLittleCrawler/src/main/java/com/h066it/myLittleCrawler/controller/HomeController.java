package com.h066it.myLittleCrawler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.h066it.myLittleCrawler.dto.MemberDto;
import com.h066it.myLittleCrawler.repository.HomeRepository;
import com.h066it.myLittleCrawler.serviceImpl.HomeServiceImpl;

@Controller
public class HomeController {

	@Autowired
	private HomeRepository repository;
	
	@Autowired
	private HomeServiceImpl service; 
	
	@RequestMapping("/")
	public String index(MemberDto dto, Authentication auth, Model model) {
		
		if(auth != null)
		model.addAttribute("auth", auth.getName());
		
		return "index";
	}
	
}

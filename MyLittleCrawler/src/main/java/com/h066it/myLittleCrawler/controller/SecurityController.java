package com.h066it.myLittleCrawler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.h066it.myLittleCrawler.dto.MemberDto;
import com.h066it.myLittleCrawler.repository.SecurityRepository;
import com.h066it.myLittleCrawler.serviceImpl.SecurityServiceImpl;

@Controller
public class SecurityController {

	@Autowired
	private SecurityRepository repository;
	
	@Autowired
	private SecurityServiceImpl service;
	
	@RequestMapping("/login")
	public String signIn() {
		
		System.out.println("signIn");
		
		return "/login/signIn";
	}
	
	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public String signUpForm() {
		
		System.out.println("signUpForm");
		
		return "/login/signUp";
	}
	
	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public String signUp(MemberDto dto) {
		
		System.out.println("signUp");
		
		//repository.save(dto.getId(), dto.getNickName(), dto.getPassword());
		service.signUp(dto);
		
		return "redirect:/";
	}
	
}

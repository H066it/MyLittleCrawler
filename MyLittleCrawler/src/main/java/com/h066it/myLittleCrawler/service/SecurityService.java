package com.h066it.myLittleCrawler.service;

import com.h066it.myLittleCrawler.dto.MemberDto;

public interface SecurityService {
	
	/* ----------- Security ฐüทร. ----------- */
	
	public void signUp(MemberDto dto);
	public MemberDto memberIdChk(String id);
	public String memberAuthChk(String id);
}

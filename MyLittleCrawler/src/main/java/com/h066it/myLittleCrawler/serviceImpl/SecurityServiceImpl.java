package com.h066it.myLittleCrawler.serviceImpl;

import java.util.ArrayList;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.h066it.myLittleCrawler.dto.AuthDto;
import com.h066it.myLittleCrawler.dto.MemberDto;
import com.h066it.myLittleCrawler.repository.AuthRepository;
import com.h066it.myLittleCrawler.repository.SecurityRepository;
import com.h066it.myLittleCrawler.service.SecurityService;

@Service
public class SecurityServiceImpl implements SecurityService, UserDetailsService {

	@Autowired
	private SecurityRepository repository;

	@Autowired
	private AuthRepository authRepository;

	@Override
	@Transactional
	public void signUp(MemberDto dto) {
		
		repository.save(dto);

		AuthDto adto = new AuthDto();
		
		adto.setId(dto.getId());
		adto.setAuthority("ROLE_USER");
		
		authRepository.save(adto);
	}
	
	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		
		MemberDto dto = memberIdChk(id);
		
		if(dto == null) {
			throw new UsernameNotFoundException("warn : username was not found!");
		}
		System.out.println(dto.getNickName());
		
		Collection<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
	    roles.add(new SimpleGrantedAuthority(memberAuthChk(id)));
	    
		UserDetails user = new User(dto.getId(), dto.getPassword(), roles);

		return user;
	}

	@Override
	public MemberDto memberIdChk(String id) {
		
		return repository.findById(id);
	}

	@Override
	public String memberAuthChk(String id) {

		return authRepository.findById(id);
	}

	
}

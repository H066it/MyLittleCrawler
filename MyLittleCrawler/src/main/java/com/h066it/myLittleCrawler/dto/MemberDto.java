package com.h066it.myLittleCrawler.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "MEMBER")
public class MemberDto {

	@Id
	@Column(name = "MID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mId;
	
	@Column(name = "ID", length = 100, nullable = false)
	private String id;
	
	@Column(name = "NICKNAME", length = 100, nullable = false)
	private String nickName;

	@Column(name = "PASSWORD", length = 100, nullable = false)
	private String password;
	
	@Column(name = "SIGNUPDATE")
	private Date signUpDate;
	
	@PrePersist
	private void prePersist() {
		signUpDate = new Date();
	}
	
}

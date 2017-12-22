package com.h066it.myLittleCrawler.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "AUTHORITIES")
public class AuthDto {

	@Id
	@Column(name = "ID", length = 100, nullable = true)
	private String id;
	
	@Column(name = "AUTHORITY", length = 100, nullable = true)
	private String authority;
	
}

package com.h066it.myLittleCrawler.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "CRAWL")
@SequenceGenerator(name = "CRAWL_SEQ_GEN", sequenceName = "CRAWL_SEQ", initialValue = 1, allocationSize = 1)
public class CrawlDto {

	@Id
	@Column(name = "CID")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "CRAWL_SEQ_GEN")
	private int cId;
	
	@NotNull
	@Size(min = 1, max = 300)
	@Column(name = "CWRITER", length = 100, nullable = false)
	private String cWriter;
	
	@NotNull
	@Size(min = 1, max = 300)
	@Column(name = "RNAME", length = 300, nullable = false)
	private String rName;
	
	@NotNull
	@Size(min = 1, max = 300)
	@Column(name = "SNAME", length = 400, nullable = false)
	private String sName;
	
	@Column(name = "CSIZE")
	private int cSize;
	
}

package com.h066it.myLittleCrawler.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "FREEBOARD")
@SequenceGenerator(name = "BOARD_SEQ_GEN", sequenceName = "BOARD_SEQ", initialValue = 1, allocationSize = 1)
public class BoardDto {

	@Id
	@Column(name = "FID")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "BOARD_SEQ_GEN")
	private int fId;
	
	@NotNull
	@Size(min = 1, max = 300)
	@Column(name = "FTITLE", length = 300, nullable = false)
	private String fTitle;
	
	@NotNull
	@Size(min = 1, max = 300)
	@Column(name = "FWRITER", length = 300, nullable = false)
	private String fWriter;
	
	@NotNull
	@Size(min = 1, max = 300)
	@Column(name = "FPASSWORD", length = 300, nullable = false)
	private String fPassword;
	
	@NotNull
	@Size(min = 1, max = 1000)
	@Column(name = "FCONTENT", length = 1000, nullable = false)
	private String fContent;

	@Column(name = "FDATE")
	private Date fDate;
	
	@Column(name = "FCOUNT")
	private int fCount;
	
	@PrePersist
	private void prePersist() {
		fDate = new Date();
	}
	
}

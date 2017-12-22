package com.h066it.myLittleCrawler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.h066it.myLittleCrawler.dto.AuthDto;

@Repository
public interface AuthRepository extends JpaRepository<AuthDto, Integer> {
	@Query(value = "SELECT authority FROM authorities a WHERE a.id = :id", nativeQuery = true)
	public String findById(@Param("id") String id);
}

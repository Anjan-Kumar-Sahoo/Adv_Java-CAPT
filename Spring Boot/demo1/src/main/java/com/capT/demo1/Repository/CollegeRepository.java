package com.capT.demo1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capT.demo1.Entity.College;

@Repository
public interface CollegeRepository extends JpaRepository<College, Integer>{

	@Query("select s from College s where s.name = :name")
	College findByName(String name);
}
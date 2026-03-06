package com.campT.emplooyeeApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.campT.emplooyeeApp.Entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer>{

}

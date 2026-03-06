package com.campT.emplooyeeApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.campT.emplooyeeApp.Entity.FileData;

@Repository
public interface FileDataRepository extends JpaRepository<FileData, Long>{

}

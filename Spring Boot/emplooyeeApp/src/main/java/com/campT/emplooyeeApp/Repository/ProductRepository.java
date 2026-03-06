package com.campT.emplooyeeApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.campT.emplooyeeApp.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}

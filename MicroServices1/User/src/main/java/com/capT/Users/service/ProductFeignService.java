package com.capT.Users.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.capT.Users.entity.Product;

@FeignClient("PRODUCT")
public interface ProductFeignService {

	@GetMapping("/product/find")
    public List<Product> findAllProducts();

    @GetMapping("/product/find/{id}")
    public Product findProductById(@PathVariable Long id);
    
    @PostMapping("/product/save")
    public Product saveProduct(@RequestBody Product product);
}

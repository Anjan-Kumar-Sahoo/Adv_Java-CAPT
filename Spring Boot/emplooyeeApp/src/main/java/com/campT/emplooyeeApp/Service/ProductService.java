package com.campT.emplooyeeApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.campT.emplooyeeApp.Entity.Product;
import com.campT.emplooyeeApp.Repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;
	
	public List<Product> saveAllproducts(List<Product> products)
	{
		return repo.saveAll(products);
	}
	
	public List<Product> productPagePagination(int pageNumber, int pageSize)
	{
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		return repo.findAll(pageable).getContent();
	}
	
	public List<Product> sortProductPage(int pageNumber, int size, String field) {
		Pageable pageable = PageRequest.of(pageNumber, size, Sort.by(field).descending());
		return repo.findAll(pageable).getContent();
	}
	//field ->id, name price |
	public List<Product> sortProductByfieldInDesc(String field){
		return repo.findAll(Sort.by(field).descending());
	}

	//field ->id,name,price
	public List<Product> sortProductByfieldInAsc(String field) {
		return repo.findAll(Sort.by(field).ascending());
	}
	
}
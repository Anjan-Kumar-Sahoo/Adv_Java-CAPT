package com.campT.emplooyeeApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campT.emplooyeeApp.Entity.Product;
import com.campT.emplooyeeApp.Service.ProductService;

@RestController @RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService service;
	
	@PostMapping("/saveAll")
	public List<Product> saveAllProducts(@RequestBody List<Product> products)
	{
		return service.saveAllproducts(products);
	}
	
	@GetMapping("/page/{pagenumber}/{size}")
	public List<Product> productPage(@PathVariable int pagenumber, @PathVariable int size)
	{
		return service.productPagePagination(pagenumber, size);
	}
	
	@GetMapping("/sort/{field}")
	public List<Product> sortProductInDesc(@PathVariable String field)
	{
		return service.sortProductByfieldInDesc(field);
	}
}

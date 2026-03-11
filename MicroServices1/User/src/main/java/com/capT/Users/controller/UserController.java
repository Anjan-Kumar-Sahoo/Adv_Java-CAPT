package com.capT.Users.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.capT.Users.entity.Product;
import com.capT.Users.entity.User;
import com.capT.Users.service.ProductFeignService;
import com.capT.Users.service.UserService;

@RestController
@RequestMapping("user/")
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private ProductFeignService pfservice;

    @PostMapping("save")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("find")
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("find/{id}")
    public User findUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }
    
    @GetMapping("connectToProduct/find")
    public ResponseEntity<String> findproduct()
    {
    	String url = "http://localhost:8080/PRODUCT/product/find";
    	RestTemplate rt = new RestTemplate();
    	return rt.exchange(url, HttpMethod.GET,null,String.class);
    }
    @GetMapping("connectToProduct/find/{id}")
    public ResponseEntity<String> findproductById(@PathVariable int id)
    {
    	String url = "http://localhost:8080/PRODUCT/product/find/"+id;
    	RestTemplate rt = new RestTemplate();
    	return rt.exchange(url, HttpMethod.GET,null,String.class);
    }
    
    @GetMapping("connectToFProduct/find")
    public List<Product> findUserProduct()
    {
    	return pfservice.findAllProducts();
    }
    @GetMapping("connectToFProduct/find/{id}")
    public Product findUserProductById(@PathVariable long id)
    {
    	return pfservice.findProductById(id);
    }
    @PostMapping("connectToFProduct/save")
    public Product saveProduct(@RequestBody Product p)
    {
    	return pfservice.saveProduct(p);
    }
}

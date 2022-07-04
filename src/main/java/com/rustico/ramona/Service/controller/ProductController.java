package com.rustico.ramona.Service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rustico.ramona.Service.entity.ProductsEntity;
import com.rustico.ramona.Service.repository.ProductRepo;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductRepo pRepo;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<ProductsEntity> getAllProducts() {
		
		return pRepo.findAll();
	}
	
	//Para no usar el ResponseStatus se haria de la siguiente forma
	/*@GetMapping
	public ResponseEntity<List<ProductEntity>> getAllProductSinStatus() {
		List<ProductEntity> productsEntites = pRepo.findAll();
		ResponseEntity<List<ProductEntity>> responseEntity = new ResponseEntity<>(productsEntites, HttpStatus.OK);
		return responseEntity;
	}*/
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void createProducts(@RequestBody ProductsEntity products) {

		System.out.println("Request: " + products.getProductName());	
		pRepo.save(products);
	}
}

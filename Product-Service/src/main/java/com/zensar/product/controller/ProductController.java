package com.zensar.product.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.product.entity.Product;
import com.zensar.product.entity.ProductDto;
import com.zensar.product.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	
	@PostMapping("/product")
	public ProductDto insertProduct(@RequestBody ProductDto productDto) {
		return productService.insertProduct(productDto);

	}

	@GetMapping("/product")
	public List<ProductDto> getProduct(@RequestHeader("auth-token") String token) {
		return productService.getProduct(token);

	}

	@PutMapping(value = "update/{productId}")
	public ProductDto updateProduct(@PathVariable int productId, @RequestBody ProductDto productDto) {
		return productService.updateProduct(productId, productDto);
	}

	@DeleteMapping("/delete/{productId}")
	public String deleteProduct(@PathVariable int productId) {
		return productService.deleteProduct(productId);

	}

}

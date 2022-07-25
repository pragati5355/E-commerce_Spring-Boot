package com.mindbowser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mindbowser.entity.Product;
import com.mindbowser.service.ProductServiceImpl;

@RestController
public class ProductController {

	@Autowired
	private ProductServiceImpl productServiceImpl;

	@PostMapping({"/addnewproduct"})
	@PreAuthorize("hasRole('Admin')")
	public Product addNewProduct(@RequestBody Product product) {
		System.out.println("Product Added Sucessfully");
		return productServiceImpl.addNewProduct(product);
	}

	@PutMapping({"/updateproduct"})
	@PreAuthorize("hasRole('Admin')")
	public String updateProduct(int id) {
		productServiceImpl.updateProduct(id);
		return "Product Updated Sucessfully";
	}

	@DeleteMapping({"/deleteproduct"})
	@PreAuthorize("hasRole('Admin')")
	public String deleteProduct(@PathVariable int id) {
		System.out.println("Deleted the Product");
		productServiceImpl.deleteProduct(id);
		return "Product Deleted !!";
	}

}

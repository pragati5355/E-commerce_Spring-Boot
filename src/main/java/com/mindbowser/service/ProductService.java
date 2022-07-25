package com.mindbowser.service;

import com.mindbowser.entity.Product;

public interface ProductService {

	public Product addNewProduct(Product product);

	public void updateProduct(int id);

	public void deleteProduct(int id);

}

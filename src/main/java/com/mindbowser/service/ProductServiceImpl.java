package com.mindbowser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mindbowser.entity.Product;
import com.mindbowser.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product addNewProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void updateProduct(int id) {
		productRepository.findById(id);
	}

	@Override
	public void deleteProduct(int id) {
		Product product = productRepository.getById(id);
		productRepository.delete(product);
	}

}

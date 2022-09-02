package com.itc.main.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itc.main.model.Product;
import com.itc.main.repository.productRepository;
@Service
public class ProductService{
	@Autowired
	private productRepository productRepository;
	public Product saveProduct(Product product) {
		Product New_product=this.productRepository.save(product);
		return New_product;
	}
	
	public Product getProductById(int Id) {
		Optional<Product> op=this.productRepository.findById(Id);
				if(op.isPresent()) {
					return op.get();
				}else 
				return null;
	}
	public Product getProductByName(String name) {
		Product product=this.productRepository.getProductByname(name);
		if(product!=null) {
			return product;
		}
		else
			return null;
		}

	
	public List<Product> getProduct() {
		List<Product> Product_list=this.productRepository.findAll();
		return Product_list;
	}
	
	public Product updateProduct(Product product) {
		if(this.productRepository.existsById(product.getId())) {
			return this.productRepository.save(product);
			
		}else
			return null;
	}

	public boolean deleteProductById(int Id) {
	this.productRepository.deleteById(Id);
	return true;
	}
	public boolean deleteProductByname(String name) {
		this.productRepository.deleteProductByname(name);
		return true;

	}
	
		
	}








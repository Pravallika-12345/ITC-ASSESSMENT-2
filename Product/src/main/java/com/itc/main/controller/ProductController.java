package com.itc.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itc.main.model.Product;
import com.itc.main.service.ProductService;

@RestController
@RequestMapping("/api/")
public class ProductController {

	@Autowired
	private ProductService ProductService;

	@GetMapping("products")
	public ResponseEntity<List<Product>> getProduct() {
		List<Product> list = this.ProductService.getProduct();
		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
	}

	@PostMapping("saveproduct")
	  public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
		 this.ProductService.saveProduct(product);
		return new ResponseEntity<Product>(product, HttpStatus.CREATED);
		
	}
	@GetMapping("productname/{name}")
	public ResponseEntity<Product> getProductByName(@PathVariable("name") String name) {
		Product p=this.ProductService.getProductByName(name);
		return new ResponseEntity<Product>(p, HttpStatus.OK);
	}
	
	@GetMapping("product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") int id){
		   Product product=this.ProductService.getProductById(id);
			   return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	@DeleteMapping("product/{id}")
	public ResponseEntity<String> deleteProductById(@PathVariable int id) {
		boolean b = this.ProductService.deleteProductById(id);
				if(b)
					return new ResponseEntity<String>("Successfully deleted", HttpStatus.OK);
				else
					return new ResponseEntity<String>("Not-found", HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("productname/{name}")
	public ResponseEntity<?> deleteProductByname(@PathVariable String name) {
	boolean product=this.ProductService.deleteProductByname(name);
	if(product==true)
		return new ResponseEntity<String>("Successfully deleted", HttpStatus.OK);
	else
		return new ResponseEntity<String>("Not-found", HttpStatus.NOT_FOUND);
	}
	@PutMapping("productname/{name}")
	  public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		Product list=this.ProductService.updateProduct(product);
		if(list!=null) {
			return new ResponseEntity<Product>(list,HttpStatus.OK);
	}else
		return new ResponseEntity<Product>( HttpStatus.NOT_FOUND);
	
	}	
}





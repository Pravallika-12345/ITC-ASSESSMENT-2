package com.itc.main.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.itc.main.model.Product;
@EnableJpaRepositories

@Repository
public interface productRepository extends JpaRepository<Product,Integer>{
	Product getProductByname(String name);
	@Transactional
	@Modifying
	@Query("DELETE FROM Product WHERE name=:name")
    Integer deleteProductByname(String name);

}

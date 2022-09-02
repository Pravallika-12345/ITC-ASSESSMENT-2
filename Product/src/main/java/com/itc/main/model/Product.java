package com.itc.main.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	    private int Id;
	    private String name;
	    private double price;
	   
	  /*  public Product(int Id, String name,double price) {
	        super();
	        this.Id = Id;
	        this.name = name;
	        this.price = price;
	        
	    }*/
	    public Product() {
	    }
	    
	    public int getId() {
	        return Id;
	    }
	    public void setId(int Id) {
	        this.Id = Id;
	    }
	    public String getname() {
	        return name;
	    }
	    public void setname(String name) {
	        this.name = name;
	    }
	    public double getprice() {
	        return price;
	    }
	    public void setprice(double price) {
	        this.price = price;
	    }
	   
	    @Override
	    public String toString() {
	        return "Product [Id=" + Id + ", namee=" + name + ", price=" + price + "]";
	    }

	}


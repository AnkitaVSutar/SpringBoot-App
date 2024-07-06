package com.jsp.ShopingCart.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.ShopingCart.DTO.Product;
import com.jsp.ShopingCart.Repository.ProductRepository;

@Repository
public class ProductDao 
{
	@Autowired
	ProductRepository repository;
	
	public String addProduct(Product product)
	{
		repository.save(product);
		return "Product added to cart successfully";
	}
	
	//to fetch all objects from DB
	public List<Product> getAllProducts()
	{
		return repository.findAll();
	}
	
	
	//to fetch one object based on ID
	
	public Product findProductById(int id)
	{
		Optional<Product> opt=repository.findById(id);
		if(opt.isPresent())
		{
			return opt.get();
		}
		return null;
	}
	
	
	//to delete an object from DB
	public String deleteProduct(int id)
	{
		Product p=findProductById(id);
		if(p !=null)
		{
			String productName=p.getProductName();
			repository.delete(p);	//or repository.deleteById(id)
			
			return productName+"Product was removed from cart";
			
		}
		
		return "product not available in cart";
			
	}
	
	
	//to update quantity of a product based on Id
	public Product updateQuantity(int id,int newQuantity)
	{
		Product p=findProductById(id);
		if(p!=null)
		{
			p.setQuantity(newQuantity);
			repository.save(p);
			return p;
		}
		return null;
	}

}

package com.jsp.ShopingCart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.ShopingCart.DTO.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>
{
	

}

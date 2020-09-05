package org.rv.shoppingbackend.dao;

import java.util.List;

import org.rv.shoppingbackend.dto.Category;
import org.rv.shoppingbackend.dto.Product;

public interface ProductDAO {
	
	
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);
	Product get(int productId);
	
	List<Product> list();
	
	//business method
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int categoryID);
	List<Product> getLatestActiveProducts(int count);
	List<Product> getLatestProductList();
	List<Product> getProductLesSprice();
	

}

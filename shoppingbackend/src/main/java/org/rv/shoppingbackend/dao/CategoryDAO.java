package org.rv.shoppingbackend.dao;

import java.util.List;

import org.rv.shoppingbackend.dto.Category;

public interface CategoryDAO {
	
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);
	Category get(int id);
	List<Category> list();
	
}

package org.rv.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.rv.shoppingbackend.dao.CategoryDAO;
import org.rv.shoppingbackend.dto.Category;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;
	private static Category category;

	@BeforeClass
	public static void init() {
		
		System.out.println("11");

		context = new AnnotationConfigApplicationContext();
		context.scan("org.rv.shoppingbackend");
		context.refresh();

		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		System.out.println("11");

	}

	@Test
	public void testCRUDCategory() {

		// add operation

		category = new Category();
System.out.println("a");
		category.setName("Mobile");
		category.setDescription("we are providing letest pics of Mobile all Breand..!!");
		category.setImageURL("mobile_log.png");

		assertEquals("category added successfully in the category table", true, categoryDAO.add(category));
		System.out.println("b");
		
		
		category.setName("Tv");
		category.setDescription("we are providing letest pics of Television all Breand..!!");
		category.setImageURL("tv_log.png");

		
		System.out.println("c");
		assertEquals("category added successfully in the category table", true, categoryDAO.add(category));

		
		System.out.println("d");
		category.setName("Laptop");
		category.setDescription("we are providing letest pics of Laptop all Breand..!!");
		category.setImageURL("laptop_log.png");
        
		System.out.println("f");
		assertEquals("category added successfully in the category table", true, categoryDAO.add(category));
		
		
		System.out.println("g");
		category.setName("Printer");
		category.setDescription("we are providing letest pics of Printer all Breand..!!");
		category.setImageURL("printer_log.png");
              
		
		System.out.println("h");
		assertEquals("category added successfully in the category table", true, categoryDAO.add(category));
	
		
		System.out.println("i");
		category.setName("freeze");
		category.setDescription("we are providing letest pics of freeze all Breand..!!");
		category.setImageURL("freeze_log.png");
		System.out.println("j");
		assertEquals("category added successfully in the category table", true, categoryDAO.add(category));
		
		
		System.out.println("k");
		category.setName("Cooler");
		category.setDescription("we are providing letest pics of Cooler all Breand..!!");
		category.setImageURL("mobile_log.png");

	
		System.out.println("l");
		assertEquals("category added successfully in the category table", true, categoryDAO.add(category));
		System.out.println("m");
		
		
		// Fetching and Update the Category
		category = categoryDAO.get(2);
		
		System.out.println("n");
		category.setName("Television");

		System.out.println("o");
		assertEquals("category Update  successfully in the category table", true, categoryDAO.update(category));
		System.out.println("p");
		// delete the Category
		category = categoryDAO.get(6);
		category.setActive(false);
		assertEquals("category delete  successfully in the category table", true, categoryDAO.update(category));

		// get Category

		assertEquals("category get successfully in the category table", 1, categoryDAO.get(1).getId());

		// get the all list element of category

		assertEquals("category get successfully in the category table", 5, categoryDAO.list().size());

	}

}

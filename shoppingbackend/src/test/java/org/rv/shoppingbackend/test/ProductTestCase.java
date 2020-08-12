package org.rv.shoppingbackend.test;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import org.rv.shoppingbackend.dao.ProductDAO;
import org.rv.shoppingbackend.dto.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;
	
	private static ProductDAO productDAO;
	
	private static  Product product;
	
	
	@BeforeClass
	public static void  init()
	{
		
		context = new AnnotationConfigApplicationContext();
		
		context.scan("org.rv.shoppingbackend");
		
		context.refresh();
		
		 productDAO = (ProductDAO)context.getBean("productDAO");
		
		
		
		
	}
	
	
	@Test
	public void testCRUDProduct()
	{
		
		product = new Product();
		
		product.setName("hp pavelian");
		
		product.setBrand("hp");
		
		product.setDescription("hp laptops");
		
		product.setQuantity(5);
		
		product.setActive(true);
		
		product.setUnitPrice(23000);
		
		product.setSupplierId(3);
		
		product.setCategoryId(2);
		
		assertEquals("category added notsuccessfully in the product table", true, productDAO.add(product));
		
		

		// Fetching and Update the Category
		product = productDAO.get(4);
		
		System.out.println("n");
		product.setName("hp i3452");

		System.out.println("o");
		assertEquals("product Update  unsuccessfully in the product table", true, productDAO.update(product));
		System.out.println("p");
		// delete the Category
		product = productDAO.get(4);
		product.setActive(false);
		assertEquals("product delete  unsuccessfully in the product table", true, productDAO.update(product));

		// get Category

		assertEquals("product 1 get unsuccessfully in the product table", 2, productDAO.get(2).getId());

		// get the all list element of category

		assertEquals("product 2 get unsuccessfully in the product table", 13, productDAO.list().size());
		
		assertEquals("product 3 get unsuccessfully in the product table", 12, productDAO.listActiveProducts().size());
		
		assertEquals("product 4 get unsuccessfully in the product table", 2, productDAO.listActiveProductsByCategory(1).size());
		
		assertEquals("product 5 get unsuccessfully in the product table", 3, productDAO.getLatestActiveProducts(3).size());

		
	}
	
	
}

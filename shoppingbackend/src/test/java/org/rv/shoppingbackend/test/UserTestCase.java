package org.rv.shoppingbackend.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.rv.shoppingbackend.dao.UserDAO;
import org.rv.shoppingbackend.dto.Address;
import org.rv.shoppingbackend.dto.Cart;
import org.rv.shoppingbackend.dto.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserTestCase {
	
	private static AnnotationConfigApplicationContext context ;
	
	 private static  UserDAO userDAO;
	
	private User user=null;
	private Address address=null;
	private Cart cart=null;
	
	
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("org.rv.shoppingbackend");
		context.refresh();
		userDAO = (UserDAO)context.getBean("userDAO");
	
		
		
	}
	
	@Test
	public void testUserCRUD()
	{
		
		
		
	}

}

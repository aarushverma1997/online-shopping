package org.rv.onlineshopping.handler;

import org.rv.onlineshopping.model.RegisterModel;
import org.rv.shoppingbackend.dao.UserDAO;
import org.rv.shoppingbackend.dto.Address;
import org.rv.shoppingbackend.dto.Cart;
import org.rv.shoppingbackend.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component(value = "registerHandler")
public class RegisterHandler {
	
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private BCryptPasswordEncoder bpasswordEncoder;
	
	public RegisterModel init()
	{
		System.out.println("data - 1");
		
		return new RegisterModel();
		
	}

	
	public void addUser(RegisterModel registerModel, User user)
	{

		System.out.println("data - 2");
		registerModel.setUser(user);
		
		
	}
	
	
	
	public String validateUser(User user,MessageContext error)
	{
		String transitionValue="success";
		
		if(!(user.getPassword().equals(user.getConfirmPassword())))
		{
			
			error.addMessage(new MessageBuilder().error().source("confirmPassword").defaultText("Password not match").build());
			return transitionValue= "failure";
			
			
		}
		
		if(userDAO.getUserByEmail(user.getEmail())!=null)
		{
			
			error.addMessage(new MessageBuilder().error().source("email").defaultText("email already taken by another user").build());
			return transitionValue= "failure";
			
			
			
		}
	
		
		return transitionValue;
	}
	
	
	
	
	public void addBilling(RegisterModel registerModel, Address billing)
	{

		System.out.println("data-3");
		registerModel.setBilling(billing);
		

		System.out.println("data-4");
	}
	
	
	
	public String storeDb(RegisterModel model)
	{
		
		String transitionValue="success";

		User user = model.getUser();
		
		if(user.getRole().equals("USER"))
		{
			
			Cart cart = new Cart();
			
			cart.setUser(user);
			
			user.setCart(cart);
			
		
		}
		
		user.setPassword(bpasswordEncoder.encode(user.getPassword()));
		
		userDAO.addUser(user);
		
	Address address =	model.getBilling();
		address.setUserId(user.getId());
		address.setBilling(true);
		userDAO.addAddress(address);

		return transitionValue;
		
	}
	
	
}

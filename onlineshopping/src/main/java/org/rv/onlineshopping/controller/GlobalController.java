package org.rv.onlineshopping.controller;

import javax.servlet.http.HttpSession;

import org.rv.onlineshopping.model.UserModel;
import org.rv.shoppingbackend.dao.UserDAO;
import org.rv.shoppingbackend.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalController {
	
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserDAO userDAO;
	
	private UserModel userModel;
	
	@ModelAttribute("userModel")
	public UserModel getUserModel()
	{
		
		if(session.getAttribute("userModel")== null)
		{
			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			
			User user = userDAO.getUserByEmail(authentication.getName());
			
			if(user!=null)
			{
				
				userModel = new UserModel();
				
				userModel.setId(user.getId());
				userModel.setFullName(user.getFirstName()+" "+user.getLastName());
				userModel.setEmail(user.getEmail());
				userModel.setRole(user.getRole());
				userModel.setMobile(user.getContactNumber());
				
				if(userModel.getRole().equals("USER"))
				{
					
					userModel.setCart(user.getCart());
					
				}
				
				session.setAttribute("userModel", userModel);
				return userModel;
			}
			
			
		}
		
		
		
	

	
	return (UserModel)session.getAttribute("userModel");
	
	}
}

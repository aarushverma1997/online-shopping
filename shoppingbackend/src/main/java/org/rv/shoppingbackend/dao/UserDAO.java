package org.rv.shoppingbackend.dao;

import java.util.List;

import org.rv.shoppingbackend.dto.Address;
import org.rv.shoppingbackend.dto.Cart;
import org.rv.shoppingbackend.dto.User;

public interface UserDAO {
	
	boolean addUser(User user);
	
	User getUserByEmail(String email);
	
	
	
	boolean addAddress(Address address);
	Address getBillingAddress(User user);
	List<Address> getListShippingAddress(User user);


}

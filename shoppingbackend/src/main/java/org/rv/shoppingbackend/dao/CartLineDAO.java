package org.rv.shoppingbackend.dao;

import java.util.List;

import org.rv.shoppingbackend.dto.Cart;
import org.rv.shoppingbackend.dto.CartLine;

public interface CartLineDAO {

	
boolean add(CartLine cartLine);
boolean update(CartLine cartLine);
boolean delete(CartLine cartLine);
CartLine get(int cartLineId);

	CartLine getCartLineByCartAndProduct(int cartId,int productID);
	List<CartLine> getList(int cartId);
	boolean updateCart(Cart cart);

	
	
}

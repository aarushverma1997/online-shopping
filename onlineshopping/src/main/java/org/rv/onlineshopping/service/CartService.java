package org.rv.onlineshopping.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.rv.onlineshopping.model.UserModel;
import org.rv.shoppingbackend.dao.CartLineDAO;
import org.rv.shoppingbackend.dao.ProductDAO;
import org.rv.shoppingbackend.dto.Cart;
import org.rv.shoppingbackend.dto.CartLine;
import org.rv.shoppingbackend.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("cartService")
public class CartService {

	@Autowired
	private CartLineDAO cartLineDAO;

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private HttpSession session;

	public Cart getCart() {

		return ((UserModel) session.getAttribute("userModel")).getCart();
	}

	public List<CartLine> getCartLine() {

		return cartLineDAO.getList(this.getCart().getId());
	}

	public String manageCartLine(int cartLineId, int count) {

		CartLine cartline = cartLineDAO.get(cartLineId);

		if (cartline == null) {

			return "result=error";
		} else {

			Product product = cartline.getProduct();

			double oldTotal = cartline.getTotal();

			if (product.getQuantity() < count) {

				return "result=unavailable";

			}
			cartline.setProductCount(count);

			cartline.setBuyingPrice(product.getUnitPrice());

			cartline.setTotal(product.getUnitPrice() * count);

			cartLineDAO.update(cartline);

			Cart cart = this.getCart();

			cart.setGrandTotal(cart.getGrandTotal() - oldTotal + cartline.getTotal());

			return "result=updated";

		}
	}

	public String deleteCartLine(int cartLineId) {

		CartLine cartline = cartLineDAO.get(cartLineId);

		if (cartline == null) {

			return "result=error";
		} else {

			Cart cart = this.getCart();

			cart.setGrandTotal(cart.getGrandTotal() - cartline.getTotal());
			cart.setCartLines(cart.getCartLines() - 1);

			cartLineDAO.updateCart(cart);

			cartLineDAO.delete(cartline);

			return "result=delete";

		}
	}

	public String addCartLine(int productId) {
		String response = null;

		Cart cart = this.getCart();

		CartLine cartLine = cartLineDAO.getCartLineByCartAndProduct(cart.getId(), productId);
     System.out.println("11111111111111111111111111111111");
		if (cartLine == null) {

			Product product = productDAO.get(productId);
		 cartLine = new CartLine();
            cartLine.setProduct(product);
			cartLine.setBuyingPrice(product.getUnitPrice());
			cartLine.setAvailable(true);
			cartLine.setCartId(cart.getId());
			cartLine.setProductCount(1);
			cartLine.setTotal(product.getUnitPrice());
			 System.out.println("11111111111111111111111111111111");
			cartLineDAO.add(cartLine);
			 System.out.println("11111111111111111111111111111111");
			cart.setCartLines(cart.getCartLines() + 1);
			cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());

			cartLineDAO.updateCart(cart);

			response = "result=added";

		}
		else
		{
			
			if(cartLine.getProductCount() < 3 )
			{
				
				
				response = this.manageCartLine(cartLine.getId(),cartLine.getProductCount() + 1);
			}
			else
			{
				
				
				response=  "result=maximum";
			}
			
		}

		return response;
	}

	
}

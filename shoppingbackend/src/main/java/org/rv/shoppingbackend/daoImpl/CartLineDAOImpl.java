package org.rv.shoppingbackend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.rv.shoppingbackend.dao.CartLineDAO;
import org.rv.shoppingbackend.dto.Cart;
import org.rv.shoppingbackend.dto.CartLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("cartLineDAO")
@Transactional
public class CartLineDAOImpl implements CartLineDAO {
	
	
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean add(CartLine cartLine) {
		try {

			sessionFactory.getCurrentSession().save(cartLine);

			return true;

		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(CartLine cartLine) {
		try {

			sessionFactory.getCurrentSession().update(cartLine);

			return true;

		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(CartLine cartLine) {

		cartLine.setAvailable(false);

		try {

			sessionFactory.getCurrentSession().delete(cartLine);

			return true;

		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public CartLine getCartLineByCartAndProduct(int cartId, int productId) {

		String query = "FROM CartLine WHERE cartId=:cartId AND product.id = :productId";

		try {

			return sessionFactory.getCurrentSession().createQuery(query, CartLine.class).setParameter("cartId", cartId)
					.setParameter("productId", productId).getSingleResult();

		} catch (Exception e) {

			return null;
		}

	}

	@Override
	public List<CartLine> getList(int cartId) {

		String query = "FROM CartLine WHERE cartId=:cartId AND available = :available";
		return sessionFactory.getCurrentSession().createQuery(query, CartLine.class).setParameter("cartId", cartId)
				.setParameter("available", true).getResultList();

	}

	@Override
	public boolean updateCart(Cart cart) {
		try {

			sessionFactory.getCurrentSession().update(cart);
			return true;

		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}

	}

	@Override
	public CartLine get(int cartLineId) {
		try {
			
			return sessionFactory.getCurrentSession().get(CartLine.class, cartLineId);
			
		} catch (Exception e) {
			return null;
		}
		
	}
}

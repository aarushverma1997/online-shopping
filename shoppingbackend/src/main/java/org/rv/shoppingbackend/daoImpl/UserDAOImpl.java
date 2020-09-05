package org.rv.shoppingbackend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.rv.shoppingbackend.dao.UserDAO;
import org.rv.shoppingbackend.dto.Address;
import org.rv.shoppingbackend.dto.Cart;
import org.rv.shoppingbackend.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addUser(User user) {
		
		
		try {
			
			sessionFactory.getCurrentSession().save(user);
			return true;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		
		
		
	}

	@Override
	public boolean addAddress(Address address) {
	try {
			
			sessionFactory.getCurrentSession().persist(address);
			return true;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		
	}

	
	

	@Override
	public User getUserByEmail(String email) {
		
		String selectUser = "FROM User WHERE email=:email";
		try {
			return sessionFactory.getCurrentSession().createQuery(selectUser, User.class).setParameter("email", email).getSingleResult();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

	@Override
	public Address getBillingAddress(User user) {
		String selectBillingaddress = "FROM Address WHERE user =:user AND isBilling = :isBilling";
		try {
			return sessionFactory.getCurrentSession().createQuery(selectBillingaddress, Address.class).setParameter("user", user).setParameter("isBilling", true).getSingleResult();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Address> getListShippingAddress(User user) {
		String selectBillingaddress = "FROM Address WHERE user =:user AND isShipping = :isShipping";
		try {
			return sessionFactory.getCurrentSession().createQuery(selectBillingaddress, Address.class).setParameter("user", user).setParameter("isShipping", true).getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}

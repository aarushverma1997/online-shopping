package org.rv.shoppingbackend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.rv.shoppingbackend.dao.ProductDAO;
import org.rv.shoppingbackend.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean add(Product product) {

		try {

			sessionFactory.getCurrentSession().save(product);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean update(Product product) {
		try {

			sessionFactory.getCurrentSession().update(product);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Product product) {
		try {
			product.setActive(false);
			sessionFactory.getCurrentSession().update(product);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Product get(int productId) {

		return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(productId));

	}

	@Override
	public List<Product> list() {

		return sessionFactory.getCurrentSession().createQuery("FROM Product", Product.class).getResultList();
	}

	@Override
	public List<Product> listActiveProducts() {
		
		String selectActiveProducts = "FROM Product WHERE isActive=:active";
		
		

		return sessionFactory.getCurrentSession().createQuery(selectActiveProducts, Product.class).setParameter("active", true).getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryID) {
String selectActiveProductsByCategory = "FROM Product WHERE isActive=:active AND categoryId = :categoryId";
		
		

		return sessionFactory.getCurrentSession().createQuery(selectActiveProductsByCategory, Product.class)
				.setParameter("active", true)
				.setParameter("categoryId", categoryID)
				.getResultList();
	
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {

		return sessionFactory.getCurrentSession().createQuery("FROM Product WHERE isActive=:active ORDER BY id", Product.class)
				.setParameter("active", true)
				.setFirstResult(0).setMaxResults(count)
				.getResultList();
	

	}

}

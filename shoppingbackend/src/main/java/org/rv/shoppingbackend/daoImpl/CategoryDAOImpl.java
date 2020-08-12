package org.rv.shoppingbackend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.rv.shoppingbackend.dao.CategoryDAO;
import org.rv.shoppingbackend.dto.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean add(Category category) {

		try {
          System.out.println("1");
			sessionFactory.getCurrentSession().save(category);

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			 System.out.println("2");
			
			return false;
		}

	}

	@Override
	public boolean update(Category category) {
		try {

			sessionFactory.getCurrentSession().update(category);
			 System.out.println("1");

			return true;

		} catch (Exception e) {
			e.printStackTrace();
		
			 System.out.println("2");
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		try {
			 System.out.println("1");
			category.setActive(false);
			sessionFactory.getCurrentSession().update(category);
			 System.out.println("11");

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			
			 System.out.println("1");
			return false;
		}
	}

	@Override
	public Category get(int id) {
		 System.out.println("1");

		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));

	}

	@Override
	public List<Category> list() {
		 System.out.println("1");
		String selectActiveCategory = "FROM Category WHERE active=:active";

		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);
		return query.getResultList();
	}

}

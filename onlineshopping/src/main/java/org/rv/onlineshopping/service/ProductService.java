package org.rv.onlineshopping.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.rv.shoppingbackend.dao.ProductDAO;
import org.rv.shoppingbackend.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.beans.support.SortDefinition;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;


@Service("productService")
public class ProductService {
	
	
	@Autowired
	private ProductDAO productDAO;
	
	
	@Autowired
	private HttpSession session;


	
	public void showProduct(String page,String type)
	{
		
		
		PagedListHolder<Product> productList;
		List<Product> listProduct=null;
		
		
		
		
		
		
		if(page == null)
		{
			
			productList = new PagedListHolder<Product>();
			
			if(type == null)
			{
				
				listProduct	 = productDAO.listActiveProducts();
				
			}
			else	if(type.equals("latest"))
			{
				
				listProduct =	productDAO.getLatestProductList();
				
			}
			else if(type.equals("tranding"))
			{
				
				
		
			}
			else if(type.equals("popular"))
			{
				
				
				
			}
			else if(type.equals("cheapest"))
			{
				
				listProduct =	productDAO.getProductLesSprice();
				
			}
			
			
			
			
			productList.setSource(listProduct);
			productList.setPageSize(20);
		
			session.setAttribute("productList", productList);
			
		
			
		}
		else if(page.equals("prev"))
		{
			productList =	(PagedListHolder<Product>)session.getAttribute("productList");
			
			productList.previousPage();
		}
		else if(page.equals("next"))
		{
			productList =	(PagedListHolder<Product>)session.getAttribute("productList");
			
			productList.nextPage();
			
		}
		else
		{
			
		int pageNum =	Integer.parseInt(page);
			
		productList =	(PagedListHolder<Product>)session.getAttribute("productList");
		productList.setPage(pageNum - 1);
		
		}
		
		
		
	}
	

}

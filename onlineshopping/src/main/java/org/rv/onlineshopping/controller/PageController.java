package org.rv.onlineshopping.controller;

import org.rv.onlineshopping.exception.ProductNotFoundException;
import org.rv.shoppingbackend.dao.CategoryDAO;
import org.rv.shoppingbackend.dao.ProductDAO;
import org.rv.shoppingbackend.dto.Category;
import org.rv.shoppingbackend.dto.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	
	@RequestMapping(value = {"/","/index","/home"})
    public ModelAndView index()
    {
		
		ModelAndView mv = new ModelAndView("page");
		
		logger.info("Inside PageController index method - INFO");
		logger.debug("Inside PageController index method - DEBUG");
		
		
		
		mv.addObject("title","Home");
		mv.addObject("userClickHome",true);
		mv.addObject("categories",categoryDAO.list());
		return mv;
		
    }
	
	@RequestMapping(value = "/about")
    public ModelAndView about()
    {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","About");
		mv.addObject("userClickAbout",true);
		return mv;
		
    }
	
	@RequestMapping(value ="/contact")
    public ModelAndView contact()
    {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Contact");
		mv.addObject("userClickContact",true);
		return mv;
		
    }
	
	/*
	 * Load the all products and base on category
	 */
	@RequestMapping(value ="show/all/products")
    public ModelAndView showAllProducts()
    {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","AllProducts");
		mv.addObject("userClickAllProducts",true);
		mv.addObject("categories",categoryDAO.list());
		return mv;
		
    }
	
	
	@RequestMapping(value ="/show/category/{id}/products")
    public ModelAndView showCategoryProducts(@PathVariable("id") int id)
    {
		/*
		 * fetch the CategoryDAO single Category
		 */
		
		Category category=null;
		category = categoryDAO.get(id);
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title",category.getName());
		mv.addObject("userClickCategoryProducts",true);
		mv.addObject("categories",categoryDAO.list());
		/*
		 * single category object
		 */
		mv.addObject("category",category);
		return mv;
		
    }
	
	
	@RequestMapping(value="/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException
	{
		
		ModelAndView mv = new ModelAndView("page");
		
		Product product = productDAO.get(id);
		
		if(product == null) throw new ProductNotFoundException();
		
		product.setViews(product.getViews() + 1);
		
		productDAO.update(product);
		
		mv.addObject("title", product.getName());
		mv.addObject("userClickShowProduct", true);
		
		mv.addObject("product", product);
		
		
		
		return mv;
	}
	
	
	
}

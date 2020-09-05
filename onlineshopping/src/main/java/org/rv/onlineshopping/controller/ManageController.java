package org.rv.onlineshopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.rv.onlineshopping.util.FileUploadUtility;
import org.rv.onlineshopping.validator.ProductValidator;
import org.rv.shoppingbackend.dao.CategoryDAO;
import org.rv.shoppingbackend.dao.ProductDAO;
import org.rv.shoppingbackend.dto.Category;
import org.rv.shoppingbackend.dto.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("/manage")
public class ManageController {
	
	private static final Logger logger =  LoggerFactory.getLogger(ManageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value ="/products", method= RequestMethod.GET)
    public ModelAndView showAllProducts(@RequestParam(name="operation",required = false) String operation)
    {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","ManageProducts");
		mv.addObject("userClickManageProducts",true);
		
		Product newProduct = new Product();
		
		newProduct.setSupplierId(1);
		newProduct.setActive(true);
		
		mv.addObject("product",newProduct);
		
		
		if(operation!=null)
		{
			if(operation.equals("product"))
			{
				
				mv.addObject("message","Product Submitted Successfully");
				
			}
			else if(operation.equals("category"))
			{
				
				
				mv.addObject("message","Category Submitted Successfully");
			}
			
			
		}
		
		return mv;
		
    }
	
	//update product handler
	@RequestMapping(value = "/{id}/product",method = RequestMethod.GET)
	  public ModelAndView showEditProducts(@PathVariable int id)
    {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","ManageProducts");
		mv.addObject("userClickManageProducts",true);
		
		Product product = productDAO.get(id);
		
		mv.addObject("product",product);
		
		return mv;
		
    }
	
	
	
	@RequestMapping(value ="/products", method= RequestMethod.POST)
	public String handProductSubmision(@Valid @ModelAttribute("product") Product modifyProduct , BindingResult result ,Model model,HttpServletRequest request)
	{
		
		if(modifyProduct.getId() == 0)
		{
		new ProductValidator().validate(modifyProduct,result);
		}
		else if(!modifyProduct.getFile().getOriginalFilename().equals(""))
		{
			
			new ProductValidator().validate(modifyProduct,result);
		}
		
		
		logger.info(modifyProduct.toString());
		
		if(result.hasErrors())
		{
			model.addAttribute("title","ManageProducts");
			model.addAttribute("userClickManageProducts",true);
			model.addAttribute("message","Product Submitted failed");
			
			return "page";
		}
		
		if(modifyProduct.getId() == 0)
		{
		productDAO.add(modifyProduct);
		}
		else
		{
			
			productDAO.update(modifyProduct);
		}
		
		
		if(!modifyProduct.getFile().getOriginalFilename().equals(""))
		{
			
	  FileUploadUtility.uploadFile(request, modifyProduct.getFile(), modifyProduct.getCode());
			
		}
		
		
		return "redirect:/manage/products?operation=product";
		
	}
	
	//activation and deactivation handler
	
	@RequestMapping(value="/product/{id}/activation",method = RequestMethod.POST)
	public String productActivationAndDeactivation(@PathVariable int id)
	{
		
		       Product product =   productDAO.get(id);
		       
		       boolean isactivation = product.isActive();
		       
		     product.setActive(!product.isActive());
		     
		     productDAO.update(product);
		
		     return (isactivation)? "product Deactivbate successfully":"product activate succesffully";
		
	}
	
	
	
	// return category list for all request
	@ModelAttribute("categories")
	public List<Category> getCategories()
	{
		
		return categoryDAO.list();
		
	}
	
	//return category object for all request
	@ModelAttribute("category")
	public Category getCategory()
	{
		
		
		return new Category();
	}
	
	
	//add category in dao
	@RequestMapping(value = "/category",method = RequestMethod.POST)
	public String handleAddcategory(@ModelAttribute Category category)
	{
		categoryDAO.add(category);
		
		return "redirect:/manage/products?operation=category";
		
	}

}

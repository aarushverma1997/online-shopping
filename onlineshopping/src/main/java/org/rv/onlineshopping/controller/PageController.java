package org.rv.onlineshopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.rv.onlineshopping.exception.ProductNotFoundException;
import org.rv.onlineshopping.service.ProductService;
import org.rv.shoppingbackend.dao.CategoryDAO;
import org.rv.shoppingbackend.dao.MailDAO;
import org.rv.shoppingbackend.dao.ProductDAO;
import org.rv.shoppingbackend.dto.Category;
import org.rv.shoppingbackend.dto.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private ProductService productService;
	
	
	@RequestMapping(value = {"/","/index","/home","/showProduct/{page}","/sort"})
    public ModelAndView index(@PathVariable(value = "page",required = false) String page,@RequestParam(value = "type",required = false) String type)
    {
		
		ModelAndView mv = new ModelAndView("page");
		
		logger.info("Inside PageController index method - INFO");
		logger.debug("Inside PageController index method - DEBUG");
		
		
		
		mv.addObject("title","Home");
		mv.addObject("userClickHome",true);
		mv.addObject("categories",categoryDAO.list());
		mv.addObject("products",productDAO.getLatestProductList());
		mv.addObject("allproducts",productDAO.getProductLesSprice());
		mv.addObject("activeproduct",productDAO.listActiveProducts());
		
		logger.info("Inside PageController index method2222 - INFO");
		logger.debug("Inside PageController index method3333 - DEBUG");
		productService.showProduct(page,type);
		logger.info("Inside PageController index method444 - INFO");
		logger.debug("Inside PageController index method555 - DEBUG");

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
    public ModelAndView contact(@RequestParam(name="message",required = false) String msg)
    {
		
		
		
		ModelAndView mv = new ModelAndView("page");
		
		if(msg!=null)
		{
			
			mv.addObject("message",msg);
		}
		
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
	
	
	
	@RequestMapping(value = "/login")
    public ModelAndView login(@RequestParam(name="error",required = false) String error,@RequestParam(name="logout",required = false) String logout)
    {
		
		ModelAndView mv = new ModelAndView("login");
		
		if(error!=null)
		{
			
			mv.addObject("message","Invalid username and password!");
		}
		if(logout!=null)
		{
			
			mv.addObject("logout","You logout successfully!");
		}
		
		
		mv.addObject("title","Login");
		return mv;
		
    }
	
	
	//error for access-denied
	@RequestMapping(value ="/access-denied")
    public ModelAndView accessDenied()
    {
		
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle","Ah! you Caught");
		mv.addObject("errorDescription","you are not authoriety to access this page");
		return mv;
		
    }

	
	@RequestMapping(value = "/perform-logout")
	public String logout(HttpServletRequest request,HttpServletResponse response)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication!=null)
		{
			
			
			new SecurityContextLogoutHandler().logout(request, response, authentication);
		}
		
		
		
		return "redirect:/login?logout";
	}
	
	
	@RequestMapping(value = "/emailSend",method= RequestMethod.POST)
	public String sendEmailHelpContact(@PathVariable(name = "name") String name ,@PathVariable(name = "email") String email ,@PathVariable(name = "message") String msg )
	{
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("configmailsender.xml");
	MailDAO  mailDAO=(MailDAO)context.getBean("mailDAO");
		
		try {
			
			String helpMailer ="blackcodderhelper@gmail.com";
			
			mailDAO.sendMail(helpMailer, name + " : "+"Email : "+email, msg);
			
			
			return "redirect:/contact?message=Your message send we replay soon";
			
		} catch (Exception e) {
			return "redirect:/contact?message=Your message not send plz resend";
		}
		
		
	}
	
}

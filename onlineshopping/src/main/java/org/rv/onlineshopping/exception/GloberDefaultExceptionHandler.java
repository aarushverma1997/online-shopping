 package org.rv.onlineshopping.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GloberDefaultExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException()
	{
		
		ModelAndView  mv = new ModelAndView("error");
		
		mv.addObject("errorTitle","The Page is not Constructed!");
		mv.addObject("errorDescription","The Page you are looking for is not available Now!");
		mv.addObject("title","404 Error Page");
		
		
		
		return mv;
		
	}	
		
		@ExceptionHandler(ProductNotFoundException.class)
		public ModelAndView handlerProductNotFoundException()
		{
			
			ModelAndView  mv = new ModelAndView("error");
			
			mv.addObject("errorTitle","Product is not available!");
			mv.addObject("errorDescription","The Product you are looking for is not available right now!");
			mv.addObject("title"," Product unavailable");
			
			
			
			return mv;
		
		
		
	}
		
		
		@ExceptionHandler(Exception.class)
		public ModelAndView handlerException(Exception ex)
		{
			
			ModelAndView  mv = new ModelAndView("error");
			
			mv.addObject("errorTitle"," Contact your Administrator!");
			mv.addObject("errorDescription",ex.toString());
			mv.addObject("title"," Error");
			
			
			
			return mv;
		
		
		
	}
	
	
	
}

package org.rv.onlineshopping.controller;

import org.rv.onlineshopping.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value ="/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	
	@RequestMapping(value = "/show")
	public ModelAndView cartShow(@RequestParam(name = "result",required = false) String result)
	{
		
		ModelAndView mv = new ModelAndView("page");
		
		if(result!=null)
		{
			switch (result){
				
				case "updated" :
					
					mv.addObject("message", "Cart items upadetd successfully");
					break;
					
                  case "added" :
					
					mv.addObject("message", "product added successfully");
					break;
					
				case "error" :
					mv.addObject("message","not updated");
					break;
				case "maximum" :
					mv.addObject("message","cartLine reached maximum entry");
					break;
				case "unavailable" :
					mv.addObject("message","product not available");
					break;
					
				case "delete" :
					mv.addObject("message","cart deleted successfully");
					break;
				
			}
			
		}
		
		
		
		mv.addObject("title","UserCart");
		mv.addObject("userClickCartShow",true);
		mv.addObject("cartLines",cartService.getCartLine());
		
		
		
		return mv;
	}
	
	@RequestMapping(value = "/{cartLineId}/update")
  public String updatecart(@PathVariable int cartLineId , @RequestParam int count)
  {
		
		String response = cartService.manageCartLine(cartLineId,count);
		
		return "redirect:/cart/show?="+response;
  }
	
	
	@RequestMapping(value = "/{cartLineId}/delete")
	  public String updatecart(@PathVariable int cartLineId )
	  {
			
			String response = cartService.deleteCartLine(cartLineId);
			
			return "redirect:/cart/show?="+response;
	  }
	
	@RequestMapping(value = "add/{productId}/product")
	  public String addcart(@PathVariable int productId )
	  {
			
			String response = cartService.addCartLine(productId);
			
			return "redirect:/cart/show?="+response;
	  }
	
	
	
}

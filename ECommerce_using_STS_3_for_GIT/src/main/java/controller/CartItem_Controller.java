package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/cart") // Note: its defined at class level here, not the usual method level
public class CartItem_Controller {
	
	@RequestMapping // it actually means this method is mapped to the same url as its class i.e /cart
	public String get(HttpServletRequest req){
		return "redirect:/cart/" + req.getSession(true).getId();
		
		// whenever, we hit /cart , it will redirect us to /cart/{sessionId}
		// this is used for retrieving the sessionID,
		// So, basically we r using the sessionID as the CartID - 
		// REMEMBER AMAZON SHOPPING - Cart will be maintained across all tabs
	}
	
	@RequestMapping(value ="/{cartId}", method = RequestMethod.GET)
	public String getCart(@PathVariable(value="cartId") String cartId, Model model){
		model.addAttribute("cartId", cartId);
		
		return "cart";
	}
}

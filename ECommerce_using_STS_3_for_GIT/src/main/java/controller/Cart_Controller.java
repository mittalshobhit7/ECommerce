package controller;

// LARGEST HANDLER !!

import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import dao.CartDAO_intrfc;
import dao.ProductDAO_intrfc;
import dao.impl.CartDAO_impl;
import model.Cart;
import model.CartItem;
import model.Product;

// This controller will mainly be providing the RESTful SERVICES

@Controller
@RequestMapping("/rest/cart")  // its just a naming convention to indicate that REST is used here
public class Cart_Controller {
	
	@Autowired
	private CartDAO_intrfc cartDAO;
	
	@Autowired
	private ProductDAO_intrfc productDAO;
	
	/*
	 @ResponseBody is for returning the model obj in JSON format -  (in the body of response) 
	 		{just to remember - REST will gv response in JSON, obviously !}
	 @RequestBody will convert the body of the request(xml/json) into a Cart obj
	
	 */
	
	// this will basically return a cart in json format
	@RequestMapping(value = "/{cartId}" , method = RequestMethod.GET)
	public @ResponseBody Cart read(@PathVariable(value="cartId") String cartId){
		
		return cartDAO.read(cartId); // Note - read() of class CartDAO is returning Cart.
	}
	
	@RequestMapping(value="/{cartId}", method = RequestMethod.PUT)  // PUT is mainly for updating
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void update(@PathVariable(value="cartId") String cartId, @RequestBody Cart cart){
			cartDAO.update(cartId, cart);
	}

	@RequestMapping(value="/{cartId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(value="cartId") String cartId){
		cartDAO.delete(cartId);
	}
	
	
	// Note - Cart is basically getting created when the product is added for the first time.
	@RequestMapping(value="/add/{prod_id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void addItem(@PathVariable(value="prod_id") String prod_id, HttpServletRequest req){
		String sessionId = req.getSession(true).getId(); // to get session id
		Cart cart = cartDAO.read(sessionId);
		
		if(cart == null){
			cart = cartDAO.create(new Cart(sessionId));
		}
		
		Product product = productDAO.getProductById(prod_id);
		if(product == null){
			throw new IllegalArgumentException(new Exception());
		}
		
		cart.addCartItem(new CartItem(product));
		
		cartDAO.update(sessionId, cart);
	}
	
	@RequestMapping(value="/remove/{prod_id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeItem(@PathVariable(value="prod_id") String prod_id, HttpServletRequest req){
		String sessionId = req.getSession(true).getId(); // to get session id
		Cart cart = cartDAO.read(sessionId);
		
		if(cart == null){
			cart = cartDAO.create(new Cart(sessionId));
		}
		
		Product product = productDAO.getProductById(prod_id);
		if(product == null){
			throw new IllegalArgumentException(new Exception());
	 	}
		
		cart.removeCartItem(new CartItem(product));
		
		cartDAO.update(sessionId, cart);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify you Payload bro !")
	public void handleClientErrors(Exception e){

	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error bro !")
	public void handleServerError(Exception e){
		
	}
	
}

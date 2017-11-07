package model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	private String cartId;
	private Map<String, CartItem> cartItems_map; // String is for the prod_id basically
	private double grandTotal;
	
	// 2 contructors
	public Cart() { // Rule - Never initialize anything in the Class, thats the
									// job of Constructor
		cartItems_map = new HashMap<String, CartItem>();
		grandTotal = 0;
	}

	public Cart(String cartId) {
		this(); // this will basically call the constructor with 0 args.
		this.cartId = cartId;
	}

	public void addCartItem(CartItem item) {
		String prod_id = item.getProduct().getProd_id();

		if (cartItems_map.containsKey(prod_id)) { // if that item is already present in cart
			CartItem existingCartItem = cartItems_map.get(prod_id);
			existingCartItem.setQuantity(existingCartItem.getQuantity() + item.getQuantity());
			cartItems_map.put(prod_id, existingCartItem);
		} else {
			cartItems_map.put(prod_id, item);
		}

		updateGrandTotal();
	}

	public void removeCartItem(CartItem item) {
		String prod_id = item.getProduct().getProd_id();
		cartItems_map.remove(prod_id);
		updateGrandTotal();
	}

	public void updateGrandTotal() {
		grandTotal = 0;
		for (CartItem item : cartItems_map.values()) {
			grandTotal = grandTotal + item.getTotalPrice();
		}
	}

	// setter,getters
	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public Map<String, CartItem> getCartItems_map() {
		return cartItems_map;
	}

	public void setCartItems_map(Map<String, CartItem> cartItems_map) {
		this.cartItems_map = cartItems_map;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
}

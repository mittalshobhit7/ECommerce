package dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import dao.CartDAO_intrfc;
import model.Cart;

@Repository
public class CartDAO_impl implements CartDAO_intrfc {

	private Map<String, Cart> listOfCarts_map; // String is basically for the cart_id

	public CartDAO_impl() { // Constructor - just to initialize the Map
		listOfCarts_map = new HashMap<String, Cart>();
	}

	@Override
	public Cart create(Cart cart) {
		if (listOfCarts_map.keySet().contains(cart.getCartId())) {
			throw new IllegalArgumentException(String.format("Can not create a cart. A cart with the given id(%) " + "already " + "exists", cart.getCartId()));
		}

		listOfCarts_map.put(cart.getCartId(), cart);
		return cart;
	}

	@Override
	public Cart read(String cartId) { // will read the id and return the corresponding cart
		return listOfCarts_map.get(cartId);
	}

	@Override
	public void update(String cartId, Cart cart) {
		if (!listOfCarts_map.keySet().contains(cartId)) {
			throw new IllegalArgumentException(String.format("Can not update cart. The cart with the given id(%) " + "does not " + "exist", cart.getCartId()));
		}
		listOfCarts_map.put(cartId, cart);
	}

	@Override
	public void delete(String cartId) {
		if (!listOfCarts_map.keySet().contains(cartId)) {
			throw new IllegalArgumentException(String.format("Can not delete cart. A cart with the given id(%) " + "does not " + "exist", cartId));
		}
		listOfCarts_map.remove(cartId);
	}
	
}

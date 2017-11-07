package dao;

import java.awt.CardLayout;
import model.Cart;

public interface CartDAO_intrfc {

	// these 4 methods are for creating/deleting/etc. the CART itself
	
	Cart create(Cart cart);
	
	Cart read(String cartId);
	
	void update(String cartId, Cart cart);
	
	void delete(String cartId);
}

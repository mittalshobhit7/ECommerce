package model;

public class CartItem {
	
	private Product product;
	private int quantity;
	private double totalPrice;
	
	public CartItem() {
		// Empty Constructor
	}

	public CartItem(Product product) {
		this.product = product;
		
		this.quantity = 1;
		this.totalPrice = product.getProd_price();
	}

	// Setters, getters
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
}
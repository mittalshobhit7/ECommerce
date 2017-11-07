package dao;

import java.util.List;

import model.Product;

public interface ProductDAO_intrfc {
	void addProduct(Product product);
	void editProduct(Product product);
	Product getProductById(String id);
	List<Product> getAllProducts();
	void deleteProduct(String id);
}

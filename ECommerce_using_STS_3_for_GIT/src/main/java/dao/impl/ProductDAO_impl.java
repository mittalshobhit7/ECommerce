package dao.impl;

import java.util.List;

import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dao.ProductDAO_intrfc;
import model.Product;

@Repository
@Transactional
public class ProductDAO_impl implements ProductDAO_intrfc {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		session.flush(); // operations will be executed only when you use this 'flush'
	}

	@Override
	public void editProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		session.flush(); // operations will be executed only when you use this 'flush'
	}
	
	@Override
	public Product getProductById(String id) {
		Session session = sessionFactory.getCurrentSession();
		Product product = (Product) session.get(Product.class, id);
		session.flush();
		return product;
	}

	@Override
	public List<Product> getAllProducts() {
		Session session = sessionFactory.getCurrentSession();
		org.hibernate.Query query = session.createQuery("from Product");
		List<Product> products = query.list();
		session.flush();
		return products;
	}

	@Override
	public void deleteProduct(String id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(getProductById(id)); // using the above method to first get the prod_id and then delete it
		session.flush();
	}
}
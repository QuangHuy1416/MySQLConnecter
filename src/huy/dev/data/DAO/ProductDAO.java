package huy.dev.data.DAO;

import java.util.List;

import huy.dev.data.model.Product;

public interface ProductDAO {
	public boolean insert(Product product);
	public boolean update(Product product);
	public boolean delete(int productId);
	public Product find(int productId);
	public List<Product> findAll();
	public List<Product> findByCategory(int id);
}

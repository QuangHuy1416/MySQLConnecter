package huy.dev.data.DAO;

import java.util.List;

import huy.dev.data.model.Category;

public interface CategoryDAO {
	public boolean insert(Category category);
	public boolean update(Category category);
	public boolean delete(int categoryId);
	public Category find(int categoryId);
	public List<Category> findAll();
}

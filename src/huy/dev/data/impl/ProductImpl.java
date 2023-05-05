package huy.dev.data.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import huy.dev.data.DAO.ProductDAO;
import huy.dev.data.driver.MySQLDriver;
import huy.dev.data.model.Category;
import huy.dev.data.model.Product;

public class ProductImpl implements ProductDAO {
	Connection con = MySQLDriver.getInstance().getConnection();

	@Override
	public boolean insert(Product product) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO PRODUCTS VALUES(NULL, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, product.getName());
			stmt.setString(2, product.getDescription());
			stmt.setDouble(3, product.getPrice());
			stmt.setInt(4, product.getQuantity());
			stmt.setInt(5, product.getCategoryId());
			stmt.setTimestamp(6, product.getCreateAt());

			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Product product) {
		String sql = "UPDATE PRODUCTS SET name = ?, description = ?, price = ?, quantity = ?, category_id = ?, created_at = ? WHERE id = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, product.getName());
			stmt.setString(2, product.getDescription());
			stmt.setDouble(3, product.getPrice());
			stmt.setInt(4, product.getQuantity());
			stmt.setInt(5, product.getCategoryId());
			stmt.setTimestamp(6, product.getCreateAt());
			return stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(int productId) {
		String sql = "DELETE FROM PRODUCTS WHERE ID = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, productId);

			return stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Product find(int productId) {
		String sql = "SELECT * FROM PRODUCTS";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				String description = rs.getString("description");
				double price = rs.getDouble("price");
				int quantity = rs.getInt("quantity");
				int categoryId = rs.getInt("category_id");
				Timestamp createdAt = rs.getTimestamp("created_at");

				return new Product(name, description, price, quantity, categoryId, createdAt);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> findAll() {
		List<Product> productList = new ArrayList<>();
		String sql = "SELECT * FROM PRODUCTS";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				double price = rs.getDouble("price");
				int quantity = rs.getInt("quantity");
				int categoryId = rs.getInt("category_id");
				Timestamp createdAt = rs.getTimestamp("created_at");

				productList.add(new Product(name, description, price, quantity, categoryId, createdAt));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
	}

	@Override
	public List<Product> findByCategory(int _categoryId) {
		List<Product> productList = new ArrayList<>();
		String sql = "SELECT * FROM PRODUCTS";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int categoryId = rs.getInt("category_id");
				if(_categoryId == categoryId)
				{
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String description = rs.getString("description");
					double price = rs.getDouble("price");
					int quantity = rs.getInt("quantity");
					Timestamp createdAt = rs.getTimestamp("created_at");
					productList.add(new Product(name, description, price, quantity, categoryId, createdAt));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
	}

}

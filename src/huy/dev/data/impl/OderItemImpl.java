package huy.dev.data.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import huy.dev.data.DAO.OrderItemDAO;
import huy.dev.data.driver.MySQLDriver;
import huy.dev.data.model.Category;
import huy.dev.data.model.OrderItem;
import huy.dev.data.model.Product;

public class OderItemImpl implements OrderItemDAO {

	Connection con = MySQLDriver.getInstance().getConnection();

	@Override
	public boolean insert(OrderItem orderItem) {
		String sql = "INSERT INTO ORDER_ITEMS VALUES(NULL, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, orderItem.getQuantity());
			stmt.setDouble(2, orderItem.getPrice());
			stmt.setInt(3, orderItem.getOrderId());
			stmt.setInt(4, orderItem.getProductId());

			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(OrderItem orderItem) {
		String sql = "UPDATE ORDER_ITEMS SET quantyti = ?, price = ?, order_id = ?, product_id = ? WHERE id = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, orderItem.getQuantity());
			stmt.setDouble(2, orderItem.getPrice());
			stmt.setInt(3, orderItem.getOrderId());
			stmt.setInt(4, orderItem.getProductId());
			return stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(int orderItemId) {
		String sql = "DELETE FROM ORDER_ITEMS WHERE ID = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, orderItemId);
			
			return stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public OrderItem find(int orderItemId) {
		String sql = "SELECT * FROM ORDER_ITEMS" ;
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int quantity = rs.getInt("quantity");
				double price = rs.getDouble("price");
				int orderId = rs.getInt("order_id");
				int productId = rs.getInt("product_id");
				
				return new OrderItem(orderItemId, quantity, price, orderId, productId);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<OrderItem> findAll() {
		List<OrderItem> oderItemList = new ArrayList<>();
		String sql = "SELECT * FROM CATEGORIES" ;
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				int quantity = rs.getInt("quantity");
				double price = rs.getDouble("price");
				int orderId = rs.getInt("order_id");
				int productId = rs.getInt("product_id");
				
				oderItemList.add(new OrderItem(id, quantity, price, orderId, productId));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return oderItemList;
	}

	@Override
	public List<OrderItem> findByProduct(int _productId) {
		List<OrderItem> orderItemList = new ArrayList<>();
		String sql = "SELECT * FROM ORDER_ITEMS";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int productId = rs.getInt("product_id");
				if(_productId == productId)
				{
					int id = rs.getInt("id");
					int quantity = rs.getInt("quantity");
					double price = rs.getDouble("price");
					int orderId = rs.getInt("order_id");
					orderItemList.add(new OrderItem(id, quantity, price, orderId, productId));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderItemList;
	}

	@Override
	public List<OrderItem> findByOrder(int _orderId) {
		List<OrderItem> orderItemList = new ArrayList<>();
		String sql = "SELECT * FROM ORDER_ITEMS";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int orderId = rs.getInt("order_id");
				if(_orderId == orderId)
				{
					int id = rs.getInt("id");
					int quantity = rs.getInt("quantity");
					double price = rs.getDouble("price");
					int productId = rs.getInt("product_id");
					orderItemList.add(new OrderItem(id, quantity, price, orderId, productId));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderItemList;
	}

}

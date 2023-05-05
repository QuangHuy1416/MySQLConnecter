package huy.dev.data.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import huy.dev.data.DAO.OrderDAO;
import huy.dev.data.driver.MySQLDriver;
import huy.dev.data.model.Category;
import huy.dev.data.model.Order;
import huy.dev.data.model.Product;

public class OrderImpl implements OrderDAO {

	Connection con = MySQLDriver.getInstance().getConnection();

	@Override
	public boolean insert(Order order) {
		String sql = "INSERT INTO ORDERS VALUES(NULL, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, order.getCode());
			stmt.setString(2, order.getStatus());
			stmt.setInt(3, order.getUserId());
			stmt.setTimestamp(4, order.getCreatedAT());
			
			stmt.execute();
		} catch (SQLException e) {
		// TODO Auto-generated catch block
				e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Order order) {
		String sql = "UPDATE ORDERS SET code = ?, status = ?, user_id = ?, created_at = ? WHERE id = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, order.getCode());
			stmt.setString(2, order.getStatus());
			stmt.setInt(3, order.getUserId());
			stmt.setTimestamp(4, order.getCreatedAT());
			stmt.setInt(5, order.getId());
			return stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(int orderId) {
		String sql = "DELETE FROM ORDERS WHERE ID = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, orderId);
			
			return stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Order find(int orderId) {
		String sql = "SELECT * FROM ORDERS";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String code = rs.getString("code");
				String status = rs.getString("status");
				int userId = rs.getInt("user_id");
				Timestamp createdAt = rs.getTimestamp("created_at");

				return new Order(orderId, code, status, userId, createdAt);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Order> findAll() {
		List<Order> orderList = new ArrayList<>();
		String sql = "SELECT * FROM ORDERS" ;
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String code = rs.getString("code");
				String status = rs.getString("status");
				int userId = rs.getInt("user_id");
				Timestamp createdAt = rs.getTimestamp("created_at");
				
				orderList.add(new Order(id, code, status, userId, createdAt));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderList;
	}

	@Override
	public List<Order> findByUser(int _userId) {
		List<Order> orderList = new ArrayList<>();
		String sql = "SELECT * FROM ORDERS";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int userId = rs.getInt("user_id");
				if(_userId == userId)
				{
					int id = rs.getInt("id");
					String code = rs.getString("code");
					String status = rs.getString("status");
					Timestamp createdAt = rs.getTimestamp("created_at");
					orderList.add(new Order(id, code, status, userId, createdAt));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderList;
	}

}

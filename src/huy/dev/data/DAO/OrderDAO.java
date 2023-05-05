package huy.dev.data.DAO;

import java.util.List;

import huy.dev.data.model.Order;
import huy.dev.data.model.Product;

public interface OrderDAO {
	public boolean insert(Order order);
	public boolean update(Order order);
	public boolean delete(int orderId);
	public Order find(int orderId);
	public List<Order> findAll();
	public List<Order> findByUser(int id);
}

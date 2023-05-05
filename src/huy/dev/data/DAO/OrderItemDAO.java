package huy.dev.data.DAO;

import java.util.List;

import huy.dev.data.model.OrderItem;
import huy.dev.data.model.Product;

public interface OrderItemDAO {
	public boolean insert(OrderItem orderItem);
	public boolean update(OrderItem orderItem);
	public boolean delete(int orderItemId);
	public OrderItem find(int orderItemId);
	public List<OrderItem> findAll();
	public List<OrderItem> findByProduct(int id);
	public List<OrderItem> findByOrder(int id);
}

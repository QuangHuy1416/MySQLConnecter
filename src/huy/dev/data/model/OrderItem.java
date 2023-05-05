package huy.dev.data.model;

import huy.dev.data.DAO.DatabaseDAO;

public class OrderItem {
	private int id;
	private int quantity;
	private double price;
	private int orderId;
	private int productId;

	public OrderItem(int quantity, double price, int orderId, int productId) {
		super();
		this.quantity = quantity;
		this.price = price;
		this.orderId = orderId;
		this.productId = productId;
	}

	public OrderItem(int id, int quantity, double price, int orderId, int productId) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.price = price;
		this.orderId = orderId;
		this.productId = productId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Product product() {
		return DatabaseDAO.getInstance().getProductDAO().find(productId);
	}
}

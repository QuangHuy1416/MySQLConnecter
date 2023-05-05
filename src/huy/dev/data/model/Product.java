package huy.dev.data.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import huy.dev.data.DAO.DatabaseDAO;

public class Product {
	private int id;
	private String name;
	private String description;
	private double price;
	private int quantity;
	private int categoryId;
	private Timestamp createAt;

	public Product(String name, String description, double price, int quantity, int categoryId, Timestamp createAt) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.categoryId = categoryId;
		this.createAt = createAt;
	}

	public Product(int id, String name, String description, double price, int quantity, int categoryId,
			Timestamp createAt) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.categoryId = categoryId;
		this.createAt = createAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public Timestamp getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}

	public Category category() {
		return DatabaseDAO.getInstance().getCategoryDAO().find(categoryId);
	}
	
	public List<Gallery> gallerys(){
		return DatabaseDAO.getInstance().getGalleryDAO().findByProduct(id);
	}
	
	public List<OrderItem> orderItem(){
		return DatabaseDAO.getInstance().getOrderItemDAO().findByProduct(id);
	}
}

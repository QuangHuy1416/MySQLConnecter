package huy.dev.data.model;

import java.sql.Timestamp;

import huy.dev.data.DAO.Database;

public class Order {
	private int id;
	private String code;
	private String status;
	private int userId;
	private Timestamp createdAT;

	public Order(String code, String status, int userId, Timestamp createdAT) {
		super();
		this.code = code;
		this.status = status;
		this.userId = userId;
		this.createdAT = createdAT;
	}

	public Order(int id, String code, String status, int userId, Timestamp createdAT) {
		super();
		this.id = id;
		this.code = code;
		this.status = status;
		this.userId = userId;
		this.createdAT = createdAT;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Timestamp getCreatedAT() {
		return createdAT;
	}

	public void setCreatedAT(Timestamp createdAT) {
		this.createdAT = createdAT;
	}
	
	public OrderItem orderItem() {
		return Database.getInstance().getOrderItemDAO().find(id);
	}
}

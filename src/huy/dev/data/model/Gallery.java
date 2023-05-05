package huy.dev.data.model;

import huy.dev.data.DAO.DatabaseDAO;

public class Gallery {
	private int id;
	private String url;
	private int productId;
	
	public Gallery(String url, int productId) {
		super();
		this.url = url;
		this.productId = productId;
	}

	public Gallery(int id, String url, int productId) {
		super();
		this.id = id;
		this.url = url;
		this.productId = productId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

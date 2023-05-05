package huy.dev.data.model;

import java.util.List;
import huy.dev.data.DAO.DatabaseDAO;

public class Category {
	private int id;
	private String name;
	private String thumbnail;

	public Category(String name, String thumbnail) {
		super();
		this.name = name;
		this.thumbnail = thumbnail;
	}

	public Category(int id, String name, String thumbnail) {
		super();
		this.id = id;
		this.name = name;
		this.thumbnail = thumbnail;
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
	
	public String getThumbnail() {
		return thumbnail;
	}
	
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	public List<Product> products(){
		return DatabaseDAO.getInstance().getProductDAO().findByCategory(id);
	}
	
}

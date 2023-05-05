package huy.dev.data.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import huy.dev.data.DAO.GalleryDAO;
import huy.dev.data.driver.MySQLDriver;
import huy.dev.data.model.Category;
import huy.dev.data.model.Gallery;
import huy.dev.data.model.Product;

public class GalleryImpl implements GalleryDAO{
	Connection con = MySQLDriver.getInstance().getConnection();
	
	@Override
	public boolean insert(Gallery gallery) {
		String sql = "INSERT INTO GALLENIES VALUES(NULL, ?, ?)";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, gallery.getUrl());
			stmt.setInt(2, gallery.getProductId());
					
			stmt.execute();
		} catch (SQLException e) {
		// TODO Auto-generated catch block
				e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Gallery gallery) {
		String sql = "UPDATE GALLENIES SET url = ?, product_id = ? WHERE id = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, gallery.getUrl());
			stmt.setInt(2, gallery.getProductId());
			stmt.setInt(3, gallery.getId());
			return stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(int galleryId) {
		String sql = "DELETE FROM GALLENIES WHERE ID = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, galleryId);
			
			return stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Gallery find(int galleryId) {
		String sql = "SELECT * FROM GALLENIES" ;
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String url = rs.getString("url");
				int product_id = rs.getInt("product_id");
				
				return new Gallery(galleryId, url, product_id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Gallery> findAll() {
		List<Gallery> gallList = new ArrayList<>();
		String sql = "SELECT * FROM GALLENIES" ;
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String url = rs.getString("url");
				int product_id = rs.getInt("product_id");
				
				gallList.add(new Gallery(id, url, product_id));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gallList;
	}

	@Override
	public List<Gallery> findByProduct(int _productId) {
		List<Gallery> galleryList = new ArrayList<>();
		String sql = "SELECT * FROM GALLRIES";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int productId = rs.getInt("product_id");
				if(_productId == productId)
				{
					int id = rs.getInt("id");
					String url = rs.getString("url");
					galleryList.add(new Gallery(id,url,productId));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return galleryList;
	}

}

package huy.dev.data.DAO;

import java.util.List;

import huy.dev.data.model.Gallery;
import huy.dev.data.model.Product;

public interface GalleryDAO {
	public boolean insert(Gallery gallery);
	public boolean update(Gallery gallery);
	public boolean delete(int galleryId);
	public Gallery find(int galleryId);
	public List<Gallery> findAll();
	public List<Gallery> findByProduct(int id);
}

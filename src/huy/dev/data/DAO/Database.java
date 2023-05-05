package huy.dev.data.DAO;

import huy.dev.data.impl.CategoryImpl;
import huy.dev.data.impl.GalleryImpl;
import huy.dev.data.impl.OderItemImpl;
import huy.dev.data.impl.OrderImpl;
import huy.dev.data.impl.ProductImpl;
import huy.dev.data.impl.UserImpl;

public class Database extends DatabaseDAO {

	@Override
	public CategoryDAO getCategoryDAO() {
		// TODO Auto-generated method stub
		return new CategoryImpl();
	}

	@Override
	public ProductDAO getProductDAO() {
		// TODO Auto-generated method stub
		return new ProductImpl();
	}

	@Override
	public GalleryDAO getGalleryDAO() {
		// TODO Auto-generated method stub
		return new GalleryImpl();
	}

	@Override
	public OrderDAO getOrderDAO() {
		// TODO Auto-generated method stub
		return new OrderImpl();
	}

	@Override
	public OrderItemDAO getOrderItemDAO() {
		// TODO Auto-generated method stub
		return new OderItemImpl();
	}

	@Override
	public UserDAO getUserDAO() {
		// TODO Auto-generated method stub
		return new UserImpl();
	}

}

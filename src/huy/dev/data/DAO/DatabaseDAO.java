package huy.dev.data.DAO;

public abstract class DatabaseDAO {
	private static DatabaseDAO instance;

	public static void init(DatabaseDAO inst) {
		instance = inst;
	}

	public static DatabaseDAO getInstance() {
		return instance;
	}

	public abstract CategoryDAO getCategoryDAO();

	public abstract ProductDAO getProductDAO();

	public abstract GalleryDAO getGalleryDAO();

	public abstract OrderDAO getOrderDAO();

	public abstract OrderItemDAO getOrderItemDAO();

	public abstract UserDAO getUserDAO();
}

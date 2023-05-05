package huy.dev.data.DAO;

import java.util.List;

import huy.dev.data.model.User;

public interface UserDAO {
	public boolean insert(User user);
	public boolean update(User user);
	public boolean delete(int userId);
	public User find(int userId);
	public List<User> findAll();
}

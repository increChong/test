package dao;

import java.util.List;

import entity.User;

public interface UserDao {
	void insertUser(User user);
	public User getUserByLoginId(String id);
	public void update(User user);
	List<User> list();
	void removeUser(String id);



}

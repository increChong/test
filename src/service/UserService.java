package service;

import java.util.List;

import entity.User;

public interface UserService {
	 void insertUser(User user);
	 public User getUserByLoginId(String id);
	 public User login(String loginid,String password);
	 public List<User> userList();
	 void removeUser(String id);
	 public void update(User user);

}

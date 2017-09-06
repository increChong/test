package service;

import java.util.List;

import entity.User;
public class UserServiceImp implements UserService{

	dao.UserDao dao=new dao.imp.UserDaoImp();
	@Override
	public void insertUser(User user) {
		dao.insertUser(user);	
	}
	@Override
	public User getUserByLoginId(String id) {
		return dao.getUserByLoginId(id);
	}
	@Override
	public User login(String loginid, String password) {
		User currentUser=getUserByLoginId(loginid);
		//System.out.println(currentUser);
		User user=null;
		if(currentUser==null){
			return null;
		}
		if(currentUser!=null){
			if(currentUser.getUpassword().equals(password)){
			//user=currentUser;
			return currentUser;
		}
		}
		//System.out.println(currentUser);
		return currentUser;
	}

	public List<User> userList() {
		
		return dao.list();
	}
	@Override
	public void removeUser(String id) {
		dao.removeUser(id);
		
	}
	@Override
	public void update(User user) {
		dao.update(user);
		
	}

}

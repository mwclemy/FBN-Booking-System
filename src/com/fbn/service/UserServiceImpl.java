package com.fbn.service;

import java.util.List;

import com.fbn.dao.UserDAO;
import com.fbn.dao.UserDAOImpl;
import com.fbn.model.User;

public class UserServiceImpl implements UserService{
	private UserDAO userDAOImpl = new UserDAOImpl();
	@Override
	public boolean registerUser(User user) {
		return userDAOImpl.registerUser(user);
	}

	@Override
	public List<User> getListOfUsers() {
		return userDAOImpl.getListOfUsers();
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return userDAOImpl.updateUserAccount(user);
	}

	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return userDAOImpl.getUserById(userId);
	}

	@Override
	public boolean deleteUserById(int userId) {
		// TODO Auto-generated method stub
		return userDAOImpl.deleteUserById(userId);
	}


}

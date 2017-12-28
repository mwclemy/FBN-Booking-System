package com.fbn.service;

import com.fbn.dao.LoginDAO;
import com.fbn.dao.LoginDAOImpl;
import com.fbn.model.User;

public class LoginServiceImpl implements LoginService {

	LoginDAO login = new LoginDAOImpl();

	@Override
	public boolean authenticateUser(String email, String password) {
		return login.authenticateUser(email, password);
	}

	@Override
	public User getUserByEmailAndPassword(String email, String password) {
		return login.getUserByEmailAndPassword(email, password);
	}

	@Override
	public User getUserById(int userId) {
		return login.getUserById(userId);
	}

}

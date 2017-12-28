package com.fbn.dao;

import com.fbn.model.User;

public interface LoginDAO {
	abstract public boolean authenticateUser(String email, String password);
	abstract public User getUserByEmailAndPassword(String email, String password);
	abstract public User getUserById(int userId);
}

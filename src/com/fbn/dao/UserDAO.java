package com.fbn.dao;

import java.util.List;

import com.fbn.model.User;

public interface UserDAO {
	public boolean registerUser(User user);

	public boolean isUserExists(User users);

	public List<User> getListOfUsers();

	public int getUserByEmailAndPassword(String email, String password);

	public boolean updateUserAccount(User user);

	public User getUserById(int userId);

	public boolean deleteUserById(int userId);
}

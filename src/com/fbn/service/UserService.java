package com.fbn.service;

import java.util.List;

import com.fbn.model.User;

public interface UserService {

	public boolean registerUser(User user);

	public List<User> getListOfUsers();

	public boolean updateUser(User user);

	public User getUserById(int userId);

	public boolean deleteUserById(int userId);
}

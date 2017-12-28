package com.fbn.service;

import com.fbn.model.Customers;
import com.fbn.model.User;

public interface LoginService {
abstract public boolean authenticateUser(String email, String password);
abstract public User getUserByEmailAndPassword(String email, String password);
abstract public User getUserById(int userId);
}

package com.fbn.service;

import java.util.List;

import com.fbn.dao.RoleDAO;
import com.fbn.dao.RoleDAOImpl;
import com.fbn.model.Role;

public class RoleServiceImpl implements RoleService {

	RoleDAO role = new RoleDAOImpl();
	@Override
	public List<Role> getListOfRoles() {
		return role.getListOfRoles();
	}

}

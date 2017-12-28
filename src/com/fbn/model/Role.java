package com.fbn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Role {
	@Id
	@GeneratedValue
	@Column(name="role_id")
	private int roleId;
	@Column(name="role_name")
	private String roleName;
	
	public Role() {
	}
	public Role(int roleId, String roleName) {
		this.roleId = roleId;
		this.roleName = roleName;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	

}

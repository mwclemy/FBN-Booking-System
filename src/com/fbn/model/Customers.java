package com.fbn.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Customers {
	@Id
	@GeneratedValue
	private int id;
	private String fname;
	private String lname;
	private String tel;
	private String email;
	private String password;
	private String address;
	private String idcard;

	public Customers() {
	}

	public Customers(String fname, String lname, String tel, String email, String password, String address,
			String idcard) {
		this.fname = fname;
		this.lname = lname;
		this.tel = tel;
		this.email = email;
		this.password = password;
		this.address = address;
		this.idcard = idcard;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}

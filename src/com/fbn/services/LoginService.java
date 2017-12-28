package com.fbn.services;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fbn.hibernate.util.HibernateUtil;
import com.fbn.model.Customers;
import com.fbn.model.User;

public class LoginService {

	public boolean authenticateCustomer(String email, String password) {
		Customers customer = getCustomerByEmailAndPassword(email, password);
		if (customer != null && customer.getEmail().equals(email) && customer.getPassword().equals(password)) {
			return true;
		} else {
			return false;
		}
	}

	public Customers getCustomerByEmailAndPassword(String email, String password) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		Customers customer = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from Customers where email='" + email + "' and password='" + password + "'");
			customer = (Customers) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return customer;
	}

	public boolean authenticateUser(String email, String password) {
		User user = getUserByEmailAndPassword(email, password);
		if (user != null && user.getEmail().equals(email) && user.getPassword().equals(password)) {
			return true;
		} else {
			return false;
		}
	}

	public User getUserByEmailAndPassword(String email, String password) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		User user = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from User where email='" + email + "' and password='" + password + "'");
			user = (User) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return user;
	}
}

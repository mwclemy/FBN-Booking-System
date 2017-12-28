package com.fbn.services;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fbn.hibernate.util.HibernateUtil;
import com.fbn.model.Customers;

public class SignupService {
	public int customerId = 0;

	public boolean registerCustomer(Customers customer) {

		Session session = HibernateUtil.openSession();
		if (isCustomerExists(customer))
			return false;

		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			session.saveOrUpdate(customer);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return true;
	}

	public boolean isCustomerExists(Customers customer) {
		Session session = HibernateUtil.openSession();
		boolean result = false;
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from Customer where email='" + customer.getEmail() + "'");
			Customers cust = (Customers) query.uniqueResult();
			tx.commit();

			if (cust != null)
				result = true;
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return result;
	}

	/* Method to get Customer By Email And Password */
	public int getCustomerByEmailAndPassword(String email, String password) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		Customers user = null;

		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from Customers where email='" + email + "' and password='" + password + "'");
			user = (Customers) query.uniqueResult();
			customerId = user.getId();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return customerId;
	}

	/* Method to UPDATE customer */
	public boolean updateCustomerAccount(int id, String tel, String email, String password) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Customers customer = (Customers) session.get(Customers.class, id);
			customer.setPassword(password);
			customer.setEmail(email);
			customer.setTel(tel);
			session.update(customer);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return true;
	}

}
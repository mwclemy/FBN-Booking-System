package com.fbn.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fbn.hibernate.util.HibernateUtil;
import com.fbn.model.Flight;
import com.fbn.model.User;

public class UserDAOImpl implements UserDAO {
	public int userId = 0;

	public boolean registerUser(User user) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		if (isUserExists(user))
			return false;

		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			session.saveOrUpdate(user);
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

	public boolean isUserExists(User users) {
		Session session = HibernateUtil.openSession();
		boolean result = false;
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from Users where email='" + users.getEmail() + "'");
			User user = (User) query.uniqueResult();
			tx.commit();

			if (user != null)
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

	/* Method to RETRIEVE all user's accounts */
	public List<User> getListOfUsers() {
		List<User> list = new ArrayList<User>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			list = session.createQuery("from User").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	/* Method to get user By Email And Password */
	public int getUserByEmailAndPassword(String email, String password) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		User user = null;

		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from User where email='" + email + "' and password='" + password + "'");
			user = (User) query.uniqueResult();
			userId = user.getId();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return userId;
	}

	/* Method to UPDATE user */
	public boolean updateUserAccount(User user) {
		boolean success = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(user);
			tx.commit();
			success = true;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return success;
	}

	@Override
	public User getUserById(int userId) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		User user = null;

		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from User where user_id='" + userId + "'");
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

	@Override
	public boolean deleteUserById(int userId) {
		boolean success = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		User user = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			user = (User) session.get(User.class, userId);
			session.delete(user);
			tx.commit();
			success = true;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return success;
	}

}

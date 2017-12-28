package com.fbn.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fbn.hibernate.util.HibernateUtil;
import com.fbn.model.CustomerRequest;
import com.fbn.model.Flight;

public class CustomerRequestService extends HttpServlet {

	public boolean registerCustomerRequest(CustomerRequest cr) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			session.saveOrUpdate(cr);
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

	/* Method to UPDATE flight */
	public void updateFlight(int id, int seats) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Flight flight = (Flight) session.get(Flight.class, id);
			//flight.setSeats((flight.getSeats() - seats));
			session.update(flight);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/* Method to get customer's all requests */
	public List<CustomerRequest> getListOfCustomerRequests(int customerId) {
		List<CustomerRequest> list = new ArrayList<CustomerRequest>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			list = session.createQuery("from CustomerRequest where customerId='"+customerId+"'").list();
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
}

package com.fbn.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fbn.hibernate.util.HibernateUtil;
import com.fbn.model.FareConfiguration;
import com.fbn.model.Flight;
import com.fbn.model.User;

public class FlightDAOImpl implements FlightDAO {
	public boolean registerFlight(Flight flight) {
		boolean success = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			session.saveOrUpdate(flight);
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

	/* Selecting non-configured flight where status id is 1 */
	@Override
	public List<Flight> getListOfFlight() {

		List<Flight> list = new ArrayList<Flight>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			list = session.createQuery("from Flight where status_id=1").list();
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

	@Override
	/* Method to UPDATE Flight */
	public boolean updateFlight(Flight flight) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		boolean success = false;
		try {
			tx = session.beginTransaction();
			session.update(flight);
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
	public Flight getFlightById(int flightId) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		Flight flight = null;

		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from Flight where flight_id='" + flightId + "'");
			flight = (Flight) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return flight;
	}

	@Override
	public boolean deleteFlightById(int flightId) {
		boolean success = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		Flight flight = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			flight = (Flight) session.get(Flight.class, flightId);
			session.delete(flight);
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

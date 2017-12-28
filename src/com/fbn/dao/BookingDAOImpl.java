package com.fbn.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fbn.hibernate.util.HibernateUtil;
import com.fbn.model.Booking;
import com.fbn.model.Flight;

public class BookingDAOImpl implements BookingDAO {

	@Override
	public boolean registerBooking(Booking booking) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		boolean success = false;
		try {
			tx = session.getTransaction();
			tx.begin();
			session.saveOrUpdate(booking);
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

	@Override
	public void updateFlightAvailabilityAndStatus(int flightId, int numSeatsBusiness, int numSeatsEconomic,
			int numSeatsFirstClass) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Flight f = (Flight) session.get(Flight.class, flightId);
			/* The status 3 means booked flight */
			f.setStatusId(3);
			session.update(f);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public List<Booking> getBookingsByUserId(int userId) {
		List<Booking> list = new ArrayList<Booking>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			list = session.createQuery("from Booking where user_id='" + userId + "'").list();
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

package com.fbn.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fbn.hibernate.util.HibernateUtil;
import com.fbn.model.Customers;
import com.fbn.model.FareConfiguration;
import com.fbn.model.Flight;

public class FareDAOImpl implements FareDAO {

	public boolean registerFareConfiguration(FareConfiguration fcs) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		boolean success = false;
		try {
			tx = session.getTransaction();
			tx.begin();
			session.saveOrUpdate(fcs);
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
	public void updateFlightFareStatus(int flightId) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Flight f = (Flight) session.get(Flight.class, flightId);
			/* The status 2 means configured flight */
			f.setStatusId(2);
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

	/* Selecting configured flight where status id is 2 */
	@Override
	public List<FareConfiguration> getListOfFare() {

		List<FareConfiguration> list = new ArrayList<FareConfiguration>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			list = session.createQuery("from FareConfiguration").list();
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
	public boolean updateFare(FareConfiguration fc) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		boolean success = false;
		try {
			tx = session.beginTransaction();
			session.update(fc);
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
	public FareConfiguration getFareById(int fareId) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		FareConfiguration fc = null;

		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from FareConfiguration where fare_id='" + fareId + "'");
			fc = (FareConfiguration) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return fc;
	}

	@Override
	public FareConfiguration getFareByFlightId(int flightId) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		FareConfiguration fc = null;

		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from FareConfiguration where flight_id='" + flightId + "'");
			fc = (FareConfiguration) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return fc;
	}
}

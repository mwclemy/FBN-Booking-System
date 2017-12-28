package com.fbn.services;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fbn.hibernate.util.HibernateUtil;
import com.fbn.model.FareConfiguration;

public class FareConfigurationService {

	public boolean registerFareConfiguration(FareConfiguration fcs) {
		System.out.println("public boolean registerFareConfiguration(FareConfiguration fcs)");
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			session.saveOrUpdate(fcs);
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

}

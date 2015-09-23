package com.mindtree.mcse.mobilemall.dao.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateXMLMappingUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			Configuration cfg = new Configuration(); // for reading the hibernate.cfg.xml
			SessionFactory sf = cfg.configure("hibernateXML.cfg.xml").buildSessionFactory(); //generate the connection
			return sf;			
			
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}
}
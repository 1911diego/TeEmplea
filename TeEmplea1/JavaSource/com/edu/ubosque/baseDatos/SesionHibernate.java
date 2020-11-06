package com.edu.ubosque.baseDatos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SesionHibernate {

	private static SessionFactory sessionFactory;
	private static Session session;
	
	static
	{
		sessionFactory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
	}

	public static Session getSessionFactory() {
		session = sessionFactory.openSession();
		return session;
	}
}

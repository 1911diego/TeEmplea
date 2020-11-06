package com.edu.ubosque.baseDatos;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SesionHibernate {

	private static final SessionFactory sf = buildSessionFactory();

	
	private static SessionFactory buildSessionFactory()
	{
		return new Configuration().configure().buildSessionFactory();
	}


	public static SessionFactory getSf() {
		return sf;
	}
}

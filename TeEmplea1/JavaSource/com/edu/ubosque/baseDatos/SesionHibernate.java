package com.edu.ubosque.baseDatos;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Clase encargada de iniciar la sesion con la base de datos
 * @author Nicolás Ávila, Sebastián Moncaleano, Diego Torres | Universidad El Bosque
 *
 */
public class SesionHibernate {

	private static final SessionFactory sf = buildSessionFactory();

	
	/**
	 * Metodo que configura la sesion
	 * @return la configuracion de la sesion
	 */
	private static SessionFactory buildSessionFactory()
	{
		return new Configuration().configure().buildSessionFactory();
	}


	/**
	 * Metodo get del SessionFactory
	 * @return SessionFactory
	 */
	public static SessionFactory getSf() {
		return sf;
	}
}

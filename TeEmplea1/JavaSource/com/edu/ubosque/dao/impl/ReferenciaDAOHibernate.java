package com.edu.ubosque.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.edu.ubosque.baseDatos.SesionHibernate;
import com.edu.ubosque.dao.IReferenciaDAO;
import com.edu.ubosque.model.ExperienciaLaboral;
import com.edu.ubosque.model.Referencias;

/**
 * Clase dao de las referencias
 * @author Nicolás Ávila, Sebastián Moncaleano, Diego Torres | Universidad El Bosque
 *
 */
public class ReferenciaDAOHibernate implements IReferenciaDAO {

	/**
	 * Metodo constructor de ReferenciaDAOHibernate
	 */
	public ReferenciaDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo que crea una nueva referencia
	 * @param crearReferencia Objeto de referencia a crear
	 * @return true si la creo, false si ocurrio algun error
	 */
	@Override
	public boolean createReferencia(Referencias crearReferencia) {
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		session.persist(crearReferencia);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public List<Referencias> readReferencia(int idReferencia) {
		return null;
	}

	/**
	 * Metodo que modifica un referencia
	 * @param referenciaAModificar objeto de referencia a modificar
	 * @return true si la modifico, false si ocurrio algun error
	 */
	@Override
	public boolean updateReferencia(Referencias modificarReferencia) {
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		session.update(modificarReferencia);
		session.getTransaction().commit();
		return true;
	}

	/**
	 * Metodo que elimina una referencia
	 * @param idReferencia id de la referencia
	 * @param ciudadanoRelacionado Ciudadano relacionado a la referencia
	 * @return true si la elimino, false si ocurrio algun error
	 */
	@Override
	public boolean deleteReferencia(Referencias deleteReferencia) {
		System.out.println(deleteReferencia.getId());
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		session.remove(deleteReferencia);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	/**
	 * Metodo que buscar una referencia por la id
	 * @param idReferencia id de la referencia
	 * @return objeto de la referencia encontrada
	 */
	@Override
	public Referencias buscarReferencia(int idReferencia) {
		String hql = "Select r FROM Referencias r WHERE r.id = "+idReferencia;
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		
		try {
		Query<Referencias> query = session.createQuery(hql);
		Referencias referenciaBuscada = query.getSingleResult();
		
		session.getTransaction().commit();
		session.close();
		
		return referenciaBuscada;
		}
		catch(Exception e)
		{
			session.close();
			return null;
		}
	}
	
	

}

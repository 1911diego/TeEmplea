package com.edu.ubosque.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.edu.ubosque.baseDatos.SesionHibernate;
import com.edu.ubosque.dao.IDatosAcademicosDAO;
import com.edu.ubosque.model.Ciudadano;
import com.edu.ubosque.model.InformacionAcademica;

/**
 * Clase dao de los datos academicos
 * @author Nicolás Ávila, Sebastián Moncaleano, Diego Torres | Universidad El Bosque
 *
 */
public class DatosAcademicosDAOHibernate implements IDatosAcademicosDAO {

	/**
	 * Metodo constructor de DatosAcademicosDAOHibernate
	 */
	public DatosAcademicosDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo que guarda la info academica en la base de datos
	 * @param crearInfoAcademica informacion academica a crear
	 * @return true si se logro guardar, false si ocurrio algun error
	 */
	@Override
	public boolean createInfoAcademica(InformacionAcademica infoAcademicaACrear) {
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		session.persist(infoAcademicaACrear);
		session.getTransaction().commit();
		return true;
	}

	
	@Override
	public List<InformacionAcademica> readInfoAcademica(int idCiudadano) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Metodo que modifica una info academica
	 * @param DatoAcademicoAModificar info academica a modificar
	 * @return true si logro modificarla, false si ocurrio algun error
	 */
	@Override
	public boolean updateInfoAcademica(InformacionAcademica infoAcademicaAModificar) {
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		session.update(infoAcademicaAModificar);
		session.getTransaction().commit();
		return true;
	}

	/**
	 * Metodo que elimina una info academica
	 * @param idInfoAcademica id de la info academica
	 * @param ciudadanoRelacionado ciudadano relacionado a la info
	 * @return true si logro eliminarla, false si ocurrio algun error
	 */
	@Override
	public boolean deleteInfoAcademica(InformacionAcademica inforAcademicaAEliminar) {
		System.out.println(inforAcademicaAEliminar.getId());
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		session.remove(inforAcademicaAEliminar);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	/**
	 * Metodo que buscar una info academica por su id
	 * @param idInfoAcademicaBuscada id de la info academica
	 * @return devuelve la info academica encontrada
	 */
	@Override
	public InformacionAcademica buscarInfoAcademicaPorId(int idInfoAcademica) {
		String hql = "Select i FROM InformacionAcademica i WHERE i.id = "+idInfoAcademica;
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		
		try {
		Query<InformacionAcademica> query = session.createQuery(hql);
		InformacionAcademica infoAcademicaBuscada = query.getSingleResult();
		
		session.getTransaction().commit();
		session.close();
		
		return infoAcademicaBuscada;
		}
		catch(Exception e)
		{
			session.close();
			return null;
		}
		
	}

}

package com.edu.ubosque.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.edu.ubosque.baseDatos.SesionHibernate;
import com.edu.ubosque.dao.IExpLaboralDAO;
import com.edu.ubosque.model.ExperienciaLaboral;

/**
 * Clase dao de la experiencia laboral
 * @author Nicolás Ávila, Sebastián Moncaleano, Diego Torres | Universidad El Bosque
 *
 */
public class ExperienciaLaboralDAOHibernate implements IExpLaboralDAO{

	/**
	 * Metodo constructor de ExperienciaLaboralDAOHibernate
	 */
	public ExperienciaLaboralDAOHibernate() {
		
	}

	/**
	 * Metodo que guarda la info de la exp laboral en la base de datos
	 * @param crearExplaboral Objeto de la exp a guardar
	 * @return true sí la guardo, false si ocurrio algún error 
	 */
	@Override
	public boolean createExperienciaLaboral(ExperienciaLaboral crearExpLaboral) {
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		session.persist(crearExpLaboral);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public List<ExperienciaLaboral> readExperienciaLaboral(int idExpLaboral) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Metodo qe modifica la exp laboral
	 * @param ExpLaboralAModificar Objeto de la exp laboral a modificar
	 * @return true sí la modificó, false sí ocurrio algún error
	 */
	@Override
	public boolean updateExperienciaLaboral(ExperienciaLaboral modificarExpLaboral) {
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		session.update(modificarExpLaboral);
		session.getTransaction().commit();
		return true;
	}

	/**
	 * Metodo que elimina una exp laboral
	 * @param idExpLaboral id de la exp laboral
	 * @param ciudadanoRelacionado Ciudadano relacionado a la exp laboral
	 * @return true sí la eliminó, false si ucurrio algún error
	 */
	@Override
	public boolean deleteExperienciaLaboral(ExperienciaLaboral deleteExpLaboral) {
		System.out.println(deleteExpLaboral.getId());
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		session.remove(deleteExpLaboral);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	/**
	 * Metodo que busca la exp laboral por la id
	 * @param idExperienciaLaboral ide la exp laboral
	 * @return Objeto de la exp laboral
	 */
	@Override
	public ExperienciaLaboral buscarExperienciaLaboral(int idExpLaboral) {
		String hql = "Select e FROM ExperienciaLaboral e WHERE e.id = "+idExpLaboral;
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		
		try {
		Query<ExperienciaLaboral> query = session.createQuery(hql);
		ExperienciaLaboral expLaboralBuscada = query.getSingleResult();
		
		session.getTransaction().commit();
		session.close();
		
		return expLaboralBuscada;
		}
		catch(Exception e)
		{
			session.close();
			return null;
		}
	}

}

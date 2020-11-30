package com.edu.ubosque.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.edu.ubosque.baseDatos.SesionHibernate;
import com.edu.ubosque.dao.IOfertaLaboralDAO;
import com.edu.ubosque.model.OfertaLaboral;

/**
 * Clase dao de la oferta laboral
 * @author Nicolás Ávila, Sebastián Moncaleano, Diego Torres | Universidad El Bosque
 *
 */
public class OfertaLaboralDAOHibernate implements IOfertaLaboralDAO {

	/**
	 * Metodo constructor de OfertaLaboralDAOHibernate
	 */
	public OfertaLaboralDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo que crea una nueva oferta laboral
	 * @param ofertaACrear Objeto de oferta laboral a crear
	 * @return true sí la creó, false sí ocurrio algun error
	 */
	@Override
	public boolean createOferta(OfertaLaboral ofertaACrear) {
		
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		session.persist(ofertaACrear);
		session.getTransaction().commit();
		return true;
	}

	/**
	 * Metodo que lista las ofertas laborales
	 * @return lista de las ofertas
	 */
	@Override
	public List<OfertaLaboral> readOferta() {

		String hql = "Select ol FROM OfertaLaboral ol";
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		Query<OfertaLaboral> query = session.createQuery(hql);
		List<OfertaLaboral> lista = query.getResultList();
		session.getTransaction().commit();
		return lista;
	}

	/**
	 * Modifica una oferta laboral
	 * @param ofertaAModificar Objeto de la oferta a modificar
	 * @return true sí la modificó, false sí ocurrio algun error
	 */
	@Override
	public boolean updateOferta(OfertaLaboral ofertaAModificar) {
		
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		session.update(ofertaAModificar);
		session.getTransaction().commit();
		return true;
	}

	/**
	 * Metodo que elimina una oferta laboral
	 * @param idOferta id de la oferta
	 * @param empresaRelacionada Empresa relacionada a la ofeta
	 * @return
	 */
	@Override
	public boolean deleteOferta(OfertaLaboral ofertaAEliminar) {
		
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		session.delete(ofertaAEliminar);
		session.getTransaction().commit();
		return true;
	}

	/**
	 * Metodo que busca una oferta por la id
	 * @param idOferta id de la oferta
	 * @return Objeto de oferta encontrado
	 */
	@Override
	public OfertaLaboral buscarOfertaPorId(int idOferta) {
		
		String hql = "Select ol FROM OfertaLaboral ol WHERE ol.idOferta = " + idOferta;
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		
		try {
			
			Query<OfertaLaboral> query = session.createQuery(hql);
			OfertaLaboral oferta = query.getSingleResult();
			
			session.getTransaction().commit();
			session.close();
			
			return oferta;
			
		} catch (Exception e) {
			
			session.close();
			return null;
		}
		
	}

}

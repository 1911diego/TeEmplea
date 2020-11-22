package com.edu.ubosque.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.edu.ubosque.baseDatos.SesionHibernate;
import com.edu.ubosque.dao.IOfertaLaboralDAO;
import com.edu.ubosque.model.OfertaLaboral;

public class OfertaLaboralDAOHibernate implements IOfertaLaboralDAO {

	public OfertaLaboralDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean createOferta(OfertaLaboral ofertaACrear) {
		
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		session.persist(ofertaACrear);
		session.getTransaction().commit();
		return true;
	}

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

	@Override
	public boolean updateOferta(OfertaLaboral ofertaAModificar) {
		
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		session.update(ofertaAModificar);
		session.getTransaction().commit();
		return true;
	}

	@Override
	public boolean deleteOferta(OfertaLaboral ofertaAEliminar) {
		
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		session.delete(ofertaAEliminar);
		session.getTransaction().commit();
		return true;
	}

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

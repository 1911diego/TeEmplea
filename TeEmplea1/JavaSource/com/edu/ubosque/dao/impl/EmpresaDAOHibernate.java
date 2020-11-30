package com.edu.ubosque.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.edu.ubosque.baseDatos.SesionHibernate;
import com.edu.ubosque.dao.IEmpresaDAO;
import com.edu.ubosque.model.Empresa;

/**
 * Clase dao de empresa
 * @author Nicolás Ávila, Sebastián Moncaleano, Diego Torres | Universidad El Bosque
 *
 */
public class EmpresaDAOHibernate implements IEmpresaDAO {

	/**
	 * Metodo cosnstructor de EmpresaDAOHibernate
	 */
	public EmpresaDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo que almacena la empresa en la base de datos
	 * @param empresaACrear objeto de la empresa a crear
	 * @returntrue sí logro guardar la empresa, false si ocurrio algun error
	 */
	@Override
	public boolean createEmpresa(Empresa empresaACrear) {
		
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		session.persist(empresaACrear);
		session.getTransaction().commit();
		return true;
	}

	/**
	 * Metodo que lista las empresa
	 * @return devuelve una lista de las empresa
	 */
	@Override
	public List<Empresa> readEmpresa() {

		String hql = "Select e FROM Empresa e";
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		Query<Empresa> query = session.createQuery(hql);
		List<Empresa> lista = query.getResultList();
		return lista;
	}

	/**
	 * Metodo que modifica una empresa
	 * @param empresaAModificar obejeto de la empresa a modificar
	 * @return true si la modifcó, false sí ocurrio algún error 
	 */
	@Override
	public boolean updateEmpresa(Empresa empresaAModificar) {
		
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		session.update(empresaAModificar);
		session.getTransaction().commit();
		return true;
	}

	/**
	 * Metodo que elimina una empresa
	 * @param empresaAEliminar Objeto de la empresa a eliminar
	 * @return true sí la eliminó, false sí ocurrio algun error
	 */
	@Override
	public boolean deleteEmpresa(Empresa empresaAEliminar) {
		
		Session session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		session.delete(empresaAEliminar);
		session.getTransaction();
		return true;
	}

	/**
	 * Metodo que busca una empresa por la id
	 * @param id Es el NIT de la empresa
	 * @return Objeto de la empresa encontrada
	 */
	@Override
	public Empresa readEmpresaPorId(int id) {
		
		String hql = "Select e FROM Empresa e WHERE e.id =" + id;
		Session sesion = SesionHibernate.getSf().getCurrentSession();
		sesion.beginTransaction();
		
		try {
			
			Query<Empresa> query = sesion.createQuery(hql);
			Empresa empresaEncontrada = query.getSingleResult();
			
			sesion.getTransaction().commit();
			sesion.close();
			
			return empresaEncontrada;
			
		} catch (Exception e) {

			sesion.close();
			return null;
		}
	}

	/**
	 * Metodo que busca una empresa por su nombre
	 * @param nombre Es el nombre de la empresa
	 * @return Objeto de la empresa encontrado
	 */
	@Override
	public Empresa readEmpresaPorNombre(String nombre) {
		
		String hql = "Select e FROM Empresa e WHERE e.nombre = '" + nombre + "'"; 
		Session sesion = SesionHibernate.getSf().getCurrentSession();
		sesion.beginTransaction();
		
		try {
			
			Query<Empresa> query = sesion.createQuery(hql);
			Empresa empresaEncontrada = query.getSingleResult();
			
			sesion.getTransaction().commit();
			sesion.close();
			
			return empresaEncontrada;
			
		} catch (Exception e) {
			sesion.close();
			return null;
		}
		
	}

}

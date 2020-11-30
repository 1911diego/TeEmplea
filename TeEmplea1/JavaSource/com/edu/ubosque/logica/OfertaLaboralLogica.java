package com.edu.ubosque.logica;

import java.util.ArrayList;
import java.util.List;

import com.edu.ubosque.dao.IOfertaLaboralDAO;
import com.edu.ubosque.dao.impl.OfertaLaboralDAOHibernate;
import com.edu.ubosque.model.Empresa;
import com.edu.ubosque.model.OfertaLaboral;

/**
 * Clase logica de la oferta laboral
 * @author Nicolás Ávila, Sebastián Moncaleano, Diego Torres | Universidad El Bosque
 *
 */
public class OfertaLaboralLogica {

	private IOfertaLaboralDAO dao;
	
	/**
	 * Metodo constructor de OfertaLaboralLogica
	 */
	public OfertaLaboralLogica() {
		dao = new OfertaLaboralDAOHibernate();
	}
	
	/**
	 * Metodo que crea una nueva oferta laboral
	 * @param ofertaACrear Objeto de oferta laboral a crear
	 * @return true sí la creó, false sí ocurrio algun error
	 */
	public boolean createOferta(OfertaLaboral ofertaACrear) {
		
		return dao.createOferta(ofertaACrear);
		
	}
	
	/**
	 * Metodo que lista las ofertas laborales
	 * @return lista de las ofertas
	 */
	public List<OfertaLaboral> readOferta(){
		
		return dao.readOferta();
		
	}
	
	/**
	 * Modifica una oferta laboral
	 * @param ofertaAModificar Objeto de la oferta a modificar
	 * @return true sí la modificó, false sí ocurrio algun error
	 */
	public boolean updateOferta(OfertaLaboral ofertaAModificar) {
		
		return dao.updateOferta(ofertaAModificar);
		
	}
	
	/**
	 * Metodo que elimina una oferta laboral
	 * @param idOferta id de la oferta
	 * @param empresaRelacionada Empresa relacionada a la ofeta
	 * @return
	 */
	public boolean deleteOferta(int idOferta, Empresa empresaRelacionada) {
		
		List<OfertaLaboral> ofertas = new ArrayList<OfertaLaboral>(empresaRelacionada.getOfertaLaborals());
		OfertaLaboral ofertaAEliminar = null;
		
		for (int i = 0; i < ofertas.size(); i++) {
			
			if(ofertas.get(i).getIdOferta() == idOferta) {
				
				ofertaAEliminar = ofertas.get(i);
			}
			
		}
		
		return dao.deleteOferta(ofertaAEliminar);
		
	}
	
	/**
	 * Metodo que busca una oferta por la id
	 * @param idOferta id de la oferta
	 * @return Objeto de oferta encontrado
	 */
	public OfertaLaboral buscarOfertaPorId(int idOferta)
	{
		OfertaLaboral ofertaLaboralBuscada = dao.buscarOfertaPorId(idOferta);
		return ofertaLaboralBuscada;
	}

}

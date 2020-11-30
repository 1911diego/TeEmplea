package com.edu.ubosque.dao;

import java.util.List;
import com.edu.ubosque.model.OfertaLaboral;

/**
 * Interfaz dao de la oferta laboral
 * @author Nicol�s �vila, Sebasti�n Moncaleano, Diego Torres | Universidad El Bosque
 *
 */
public interface IOfertaLaboralDAO {
	
	/**
	 * Metodo que crea una nueva oferta laboral
	 * @param ofertaACrear Objeto de oferta laboral a crear
	 * @return true s� la cre�, false s� ocurrio algun error
	 */
	boolean createOferta(OfertaLaboral ofertaACrear);
	
	/**
	 * Metodo que lista las ofertas laborales
	 * @return lista de las ofertas
	 */
	List<OfertaLaboral> readOferta();
	
	/**
	 * Modifica una oferta laboral
	 * @param ofertaAModificar Objeto de la oferta a modificar
	 * @return true s� la modific�, false s� ocurrio algun error
	 */
	boolean updateOferta(OfertaLaboral ofertaAModificar);
	
	/**
	 * Metodo que elimina una oferta laboral
	 * @param idOferta id de la oferta
	 * @param empresaRelacionada Empresa relacionada a la ofeta
	 * @return
	 */
	boolean deleteOferta(OfertaLaboral ofertaAEliminar);
	
	/**
	 * Metodo que busca una oferta por la id
	 * @param idOferta id de la oferta
	 * @return Objeto de oferta encontrado
	 */
	OfertaLaboral buscarOfertaPorId(int idOferta);

}

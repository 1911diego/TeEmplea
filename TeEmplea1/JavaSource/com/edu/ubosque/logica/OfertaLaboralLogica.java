package com.edu.ubosque.logica;

import java.util.ArrayList;
import java.util.List;

import com.edu.ubosque.dao.IOfertaLaboralDAO;
import com.edu.ubosque.dao.impl.OfertaLaboralDAOHibernate;
import com.edu.ubosque.model.Empresa;
import com.edu.ubosque.model.OfertaLaboral;

public class OfertaLaboralLogica {

	private IOfertaLaboralDAO dao;
	
	public OfertaLaboralLogica() {
		dao = new OfertaLaboralDAOHibernate();
	}
	
	public boolean createOferta(OfertaLaboral ofertaACrear) {
		
		return dao.createOferta(ofertaACrear);
		
	}
	
	public List<OfertaLaboral> readOferta(){
		
		return dao.readOferta();
		
	}
	
	public boolean updateOferta(OfertaLaboral ofertaAModificar) {
		
		return dao.updateOferta(ofertaAModificar);
		
	}
	
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
	
	public OfertaLaboral buscarOfertaPorId(int idOferta)
	{
		OfertaLaboral ofertaLaboralBuscada = dao.buscarOfertaPorId(idOferta);
		return ofertaLaboralBuscada;
	}

}

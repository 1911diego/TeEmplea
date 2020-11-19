package com.edu.ubosque.dao;

import java.util.List;
import com.edu.ubosque.model.OfertaLaboral;

public interface IOfertaLaboralDAO {
	
	boolean createOferta(OfertaLaboral ofertaACrear);
	
	List<OfertaLaboral> readOferta();
	
	boolean updateOferta(OfertaLaboral ofertaAModificar);
	
	boolean deleteOferta(OfertaLaboral ofertaAEliminar);

}

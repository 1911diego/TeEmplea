package com.edu.ubosque.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.edu.ubosque.logica.UsuarioLogica;

@ManagedBean
//@SessionScoped
public class UsuarioMB {

//	private UsuarioLogica ul; 
//	private List<Usuarios> listaUsuarios;
//	private String usuario;
//	private String clave;
//	private String usuarioEncontrado;
//	private String claveEncontrada;
//	private boolean salida = false;
//	
//	public UsuarioMB() {
//		
//		ul = new UsuarioLogica();
//		listaUsuarios = ul.readUsuario();
//		
//		
//	}
//	
//	public String validarUsuario() {
//		
//		if(usuario != null && clave != null) {
//			for (int i = 0; i < listaUsuarios.size(); i++) {
//				System.out.println(listaUsuarios);
//				if(usuario.equalsIgnoreCase(listaUsuarios.get(i).getNombreUsuario()) && clave.equals(listaUsuarios.get(i).getContrasena())) {
//					usuarioEncontrado = listaUsuarios.get(i).getNombreUsuario();
//					claveEncontrada = listaUsuarios.get(i).getContrasena();
//					salida = true;
//				}
//			}
//		}
//		else
//		{
//			salida = false;
//		}
//		
//		return "ingreso";
//
//	}
//
//	public List<Usuarios> getListaUsuarios() {
//		return listaUsuarios;
//	}
//
//	public void setListaUsuarios(List<Usuarios> listaUsuarios) {
//		this.listaUsuarios = listaUsuarios;
//	}
//
//	public String getUsuario() {
//		return usuario;
//	}
//
//	public void setUsuario(String usuario) {
//		this.usuario = usuario;
//	}
//
//	public String getClave() {
//		return clave;
//	}
//
//	public void setClave(String clave) {
//		this.clave = clave;
//	}
//
//	public boolean isSalida() {
//		return salida;
//	}
//
//	public void setSalida(boolean salida) {
//		this.salida = salida;
//	}
//
//	public String getUsuarioEncontrado() {
//		return usuarioEncontrado;
//	}
//
//	public void setUsuarioEncontrado(String usuarioEncontrado) {
//		this.usuarioEncontrado = usuarioEncontrado;
//	}
//
//	public String getClaveEncontrada() {
//		return claveEncontrada;
//	}
//
//	public void setClaveEncontrada(String claveEncontrada) {
//		this.claveEncontrada = claveEncontrada;
//	}
//
//	
//	

}

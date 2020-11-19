package com.edu.ubosque.model;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/* Clase que gestiona el env�o de correos
 */

/*
 * <h1>Gestiona envio de correos</h1>
* Se encarga de modelar el env�o de correos
* @version 1.0
* @author Juan Pablo Araque, Nicol�s �vila, Sebasti�n Moncaleano, Diego Torres | Universidad El Bosque
 */
public class Correo {
	
	/**
	 * M�todo que env�a un correo cuando un cupo de tarjeta ha sido aprobado
	 * @param adjuntoRuta ruta del archivo a adjuntar
	 * @param nombreAdjunto nombre del documento a adjuntar
	 * @param destino correo al que se enviar� el mail
	 * @param creditCard numero de tarjeta al que se le aprob� el cr�dito
	 * @param monto monto que se le aprob� a un cliente
	 * @return true si se envi� el correo, false si ocurri� un error y no se envi�
	 */
	public boolean enviarCorreoCupoAprobado(String adjuntoRuta, String nombreAdjunto, String destino, String creditCard, String monto) {
			
			try {
				
				Properties p = new Properties();
				p.put("mail.smtp.host","smtp.gmail.com");
				p.put("mail.smtp.ssl.trust", "smtp.gmail.com");
				p.setProperty("mail.smtp.starttls.enable", "true");
				p.setProperty("mail.smtp.port", "587");
				p.setProperty("mail.smtp.user", "hideandseekconfirm@gmail.com");
				p.setProperty("mail.smtp.auth", "true");
				
				
				Session s = Session.getDefaultInstance(p, null);
				String mensaje = "Felicidades." + "\n" 
				+ "Fue aprobado un cupo de $" + monto + " a la tarjeta de cr�dito numero: " + creditCard + "." +"\n" 
				+ "Hide&Seek";
				
				BodyPart texto = new MimeBodyPart();
				texto.setText(mensaje);
				BodyPart adjunto = new MimeBodyPart();
				
				if (!adjuntoRuta.equals("")) {
					adjunto.setDataHandler(new DataHandler(new FileDataSource(adjuntoRuta)));
					adjunto.setFileName(nombreAdjunto);
				}
				
				MimeMultipart m = new MimeMultipart();
				m.addBodyPart(texto);
				
				if (!adjuntoRuta.equals("")) {
					m.addBodyPart(adjunto);	
				}
				
				MimeMessage mens = new MimeMessage(s);
				mens.setFrom(new InternetAddress("hideandseekconfirm@gmail.com"));
				mens.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
				mens.setSubject("CUPO APROBADO | Credit card number: " + creditCard);
				mens.setContent(m);
				
				Transport tr = s.getTransport("smtp");
				tr.connect("hideandseekconfirm@gmail.com","duhfahxeutmqwvrk");
				tr.sendMessage(mens, mens.getAllRecipients());
				tr.close();
				
				return true;
				
				
				
			} catch (Exception e) {
				System.out.println("error"+e);
				
				return false;
			}
			
			
		}
	
	/**
	 * M�todo que env�a un correo con una factura de compras
	 * @param adjuntoRuta ruta del archivo a adjuntar
	 * @param nombreAdjunto nombre del documento a adjuntar
	 * @param destino correo al que se enviar� el mail
	 * @param creditCard numero de tarjeta al que realiz� la compra
	 * @return true si se envi� el correo, false si ocurri� un error y no se envi�
	 */
	
	public boolean enviarCorreoFactura(String adjuntoRuta, String nombreAdjunto, String destino, String creditCard) {
		
		try {
			
			Properties p = new Properties();
			p.put("mail.smtp.host","smtp.gmail.com");
			p.put("mail.smtp.ssl.trust", "smtp.gmail.com");
			p.setProperty("mail.smtp.starttls.enable", "true");
			p.setProperty("mail.smtp.port", "587");
			p.setProperty("mail.smtp.user", "hideandseekconfirm@gmail.com");
			p.setProperty("mail.smtp.auth", "true");
			
			
			Session s = Session.getDefaultInstance(p, null);
			String mensaje = "Factura electr�nica" + "\n"
			+ "Perteneciente a la tarjeta de cr�dito numero: " + creditCard + "\n" 
			+ "Hide&Seek";
			
			BodyPart texto = new MimeBodyPart();
			texto.setText(mensaje);
			BodyPart adjunto = new MimeBodyPart();
			
			if (!adjuntoRuta.equals("")) {
				adjunto.setDataHandler(new DataHandler(new FileDataSource(adjuntoRuta)));
				adjunto.setFileName(nombreAdjunto);
			}
			
			MimeMultipart m = new MimeMultipart();
			m.addBodyPart(texto);
			
			if (!adjuntoRuta.equals("")) {
				m.addBodyPart(adjunto);	
			}
			
			MimeMessage mens = new MimeMessage(s);
			mens.setFrom(new InternetAddress("hideandseekconfirm@gmail.com"));
			mens.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
			mens.setSubject("FACTURA ELECTR�NICA | Credit card number: " + creditCard);
			mens.setContent(m);
			
			Transport tr = s.getTransport("smtp");
			tr.connect("hideandseekconfirm@gmail.com","duhfahxeutmqwvrk");
			tr.sendMessage(mens, mens.getAllRecipients());
			tr.close();
			
			return true;
			
			
			
		} catch (Exception e) {
			System.out.println("error"+e);
			
			return false;
		}
		
		
	}
	
	/**
	 * M�todo que env�a un correo con el extracto de compras de una tarjeta de cr�dito
	 * @param adjuntoRuta ruta del archivo a adjuntar
	 * @param nombreAdjunto nombre del documento a adjuntar
	 * @param destino correo al que se enviar� el mail
	 * @param creditCard numero de tarjeta del que se gener� el extracto
	 * @return true si se envi� el correo, false si ocurri� un error y no se envi�
	 */	
	
	
	public boolean enviarCorreoExtracto(String adjuntoRuta, String nombreAdjunto, String destino, String creditCard) {
			
			try {
				
				Properties p = new Properties();
				p.put("mail.smtp.host","smtp.gmail.com");
				p.put("mail.smtp.ssl.trust", "smtp.gmail.com");
				p.setProperty("mail.smtp.starttls.enable", "true");
				p.setProperty("mail.smtp.port", "587");
				p.setProperty("mail.smtp.user", "hideandseekconfirm@gmail.com");
				p.setProperty("mail.smtp.auth", "true");
				
				
				Session s = Session.getDefaultInstance(p, null);
				String mensaje = "Extracto bancario." + "\n"
				+ "Perteneciente a la tarjeta de cr�dito numero: " + creditCard + "\n" 
				+ "Hide&Seek";
				
				BodyPart texto = new MimeBodyPart();
				texto.setText(mensaje);
				BodyPart adjunto = new MimeBodyPart();
				
				if (!adjuntoRuta.equals("")) {
					adjunto.setDataHandler(new DataHandler(new FileDataSource(adjuntoRuta)));
					adjunto.setFileName(nombreAdjunto);
				}
				
				MimeMultipart m = new MimeMultipart();
				m.addBodyPart(texto);
				
				if (!adjuntoRuta.equals("")) {
					m.addBodyPart(adjunto);	
				}
				
				MimeMessage mens = new MimeMessage(s);
				mens.setFrom(new InternetAddress("hideandseekconfirm@gmail.com"));
				mens.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
				mens.setSubject("Extracto bancario | Credit card number: " + creditCard);
				mens.setContent(m);
				
				Transport tr = s.getTransport("smtp");
				tr.connect("hideandseekconfirm@gmail.com","duhfahxeutmqwvrk");
				tr.sendMessage(mens, mens.getAllRecipients());
				tr.close();
				
				return true;
				
				
				
			} catch (Exception e) {
				System.out.println("error"+e);
				
				return false;
			}
			
			
		}
	
	/**
	 * M�todo que env�a un correo de confirmaci�n con el user y clave del usuario regitrado
	 * @param adjuntoRuta ruta del archivo a adjuntar
	 * @param nombreAdjunto nombre del documento a adjuntar
	 * @param destino correo al que se enviar� el mail
	 * @param usuarioHide Usuario registrado
	 * @param claveHide clave del usuario registrado
	 * @return true si se envi� el correo, false si ocurri� un error y no se envi�
	 */	
	


	public boolean enviarCorreoRegistro(String adjuntoRuta, String nombreAdjunto, String destino, String usuarioHide, String claveHide) {
		
		try {
			
			Properties p = new Properties();
			p.put("mail.smtp.host","smtp.gmail.com");
			p.put("mail.smtp.ssl.trust", "smtp.gmail.com");
			p.setProperty("mail.smtp.starttls.enable", "true");
			p.setProperty("mail.smtp.port", "587");
			p.setProperty("mail.smtp.user", "hideandseekconfirm@gmail.com");
			p.setProperty("mail.smtp.auth", "true");
			
			
			Session s = Session.getDefaultInstance(p, null);
			String mensaje = "Acabas de registrate en nuestra plataforma Hide&Seek." + "\n"
			+ "Tu usuario es: " + usuarioHide + "\n" 
			+ "Tu contrase�a es: " + claveHide + "\n" 
			+ "Recuerda que esto no significa que se te haya aprobado un cupo a tu tarjeta." + "\n" 
			+ "Cuando se te apruebe un cupo a tu tarjeta, recibir�s un correo";
			
			BodyPart texto = new MimeBodyPart();
			texto.setText(mensaje);
			BodyPart adjunto = new MimeBodyPart();
			
			if (!adjuntoRuta.equals("")) {
				adjunto.setDataHandler(new DataHandler(new FileDataSource(adjuntoRuta)));
				adjunto.setFileName(nombreAdjunto);
			}
			
			MimeMultipart m = new MimeMultipart();
			m.addBodyPart(texto);
			
			if (!adjuntoRuta.equals("")) {
				m.addBodyPart(adjunto);	
			}
			
			MimeMessage mens = new MimeMessage(s);
			mens.setFrom(new InternetAddress("hideandseekconfirm@gmail.com"));
			mens.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
			mens.setSubject("Confirmaci�n de suscripci�n Hide&Seek");
			mens.setContent(m);
			
			Transport tr = s.getTransport("smtp");
			tr.connect("hideandseekconfirm@gmail.com","duhfahxeutmqwvrk");
			tr.sendMessage(mens, mens.getAllRecipients());
			tr.close();
			
			return true;
			
			
			
		} catch (Exception e) {
			System.out.println("error"+e);
			
			return false;
		}
		
		
	}
	
	
	
}

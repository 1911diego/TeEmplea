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

/* Clase que gestiona el envío de correos
 */

/*
 * <h1>Gestiona envio de correos</h1>
* Se encarga de modelar el envío de correos
* @version 1.0
* @author Juan Pablo Araque, Nicolás Ávila, Sebastián Moncaleano, Diego Torres | Universidad El Bosque
 */
public class Correo {
	
	/**
	 * Método que envía un correo cuando un cupo de tarjeta ha sido aprobado
	 * @param adjuntoRuta ruta del archivo a adjuntar
	 * @param nombreAdjunto nombre del documento a adjuntar
	 * @param destino correo al que se enviará el mail
	 * @param creditCard numero de tarjeta al que se le aprobó el crédito
	 * @param monto monto que se le aprobó a un cliente
	 * @return true si se envió el correo, false si ocurrió un error y no se envió
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
				+ "Fue aprobado un cupo de $" + monto + " a la tarjeta de crédito numero: " + creditCard + "." +"\n" 
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
	 * Método que envía un correo con una factura de compras
	 * @param adjuntoRuta ruta del archivo a adjuntar
	 * @param nombreAdjunto nombre del documento a adjuntar
	 * @param destino correo al que se enviará el mail
	 * @param creditCard numero de tarjeta al que realizó la compra
	 * @return true si se envió el correo, false si ocurrió un error y no se envió
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
			String mensaje = "Factura electrónica" + "\n"
			+ "Perteneciente a la tarjeta de crédito numero: " + creditCard + "\n" 
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
			mens.setSubject("FACTURA ELECTRÓNICA | Credit card number: " + creditCard);
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
	 * Método que envía un correo con el extracto de compras de una tarjeta de crédito
	 * @param adjuntoRuta ruta del archivo a adjuntar
	 * @param nombreAdjunto nombre del documento a adjuntar
	 * @param destino correo al que se enviará el mail
	 * @param creditCard numero de tarjeta del que se generó el extracto
	 * @return true si se envió el correo, false si ocurrió un error y no se envió
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
				+ "Perteneciente a la tarjeta de crédito numero: " + creditCard + "\n" 
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
	 * Método que envía un correo de confirmación con el user y clave del usuario regitrado
	 * @param adjuntoRuta ruta del archivo a adjuntar
	 * @param nombreAdjunto nombre del documento a adjuntar
	 * @param destino correo al que se enviará el mail
	 * @param usuarioHide Usuario registrado
	 * @param claveHide clave del usuario registrado
	 * @return true si se envió el correo, false si ocurrió un error y no se envió
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
			+ "Tu contraseña es: " + claveHide + "\n" 
			+ "Recuerda que esto no significa que se te haya aprobado un cupo a tu tarjeta." + "\n" 
			+ "Cuando se te apruebe un cupo a tu tarjeta, recibirás un correo";
			
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
			mens.setSubject("Confirmación de suscripción Hide&Seek");
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

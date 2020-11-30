package com.edu.ubosque.logica;

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
* @author Nicolás Ávila, Sebastián Moncaleano, Diego Torres | Universidad El Bosque
 */
public class Correo {
	
	/**
	 * Método que envía un correo cuando un usuario se registra
	 * @param adjuntoRuta ruta del archivo a adjuntar
	 * @param nombreAdjunto nombre del documento a adjuntar
	 * @param destino correo al que se enviará el mail
	 * @param usuarioTE Usuario registrado
	 * @param claveTE clave del usuario registrado
	 * @return true si se envió el correo, false si ocurrió un error y no se envió
	 */
	public boolean enviarCorreoRegistroExitoso(String adjuntoRuta, String nombreAdjunto, String destino, String usuarioTE, String claveTE) {
			
			try {
				
				Properties p = new Properties();
				p.put("mail.smtp.host","smtp.gmail.com");
				p.put("mail.smtp.ssl.trust", "smtp.gmail.com");
				p.setProperty("mail.smtp.starttls.enable", "true");
				p.setProperty("mail.smtp.port", "587");
				p.setProperty("mail.smtp.user", "teempleaconfirm@gmail.com");
				p.setProperty("mail.smtp.auth", "true");
				
				
				Session s = Session.getDefaultInstance(p, null);
				String mensaje = "Acabas de registrate en nuestra plataforma TeEmplea." + "\n"
						+ "Tu usuario es: " + usuarioTE + "\n" 
						+ "Tu contraseña es: " + claveTE + "\n" 
						+ "Recuerda que si tienes algún problema con el registro puedes responder este correo y uno de nuestros asesores te ayudará." + "\n" 
						+ "Para nosotros es un placer trabajar a su lado";
				
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
				mens.setFrom(new InternetAddress("teempleaconfirm@gmail.com"));
				mens.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
				mens.setSubject("REGISTRO EXITOSO | Te Emplea: " + usuarioTE );
				mens.setContent(m);
				
				Transport tr = s.getTransport("smtp");
				tr.connect("teempleaconfirm@gmail.com","gojwpyhhjfxkciue");
				tr.sendMessage(mens, mens.getAllRecipients());
				tr.close();
				
				return true;
				
				
				
			} catch (Exception e) {
				System.out.println("error"+e);
				
				return false;
			}
			
			
		}
	
	
}

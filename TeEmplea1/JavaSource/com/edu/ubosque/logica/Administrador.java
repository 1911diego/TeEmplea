package com.edu.ubosque.logica;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
  
	/* Clase que modela al administrador del negocio
	 */
	
	/*
	 * <h1>Modela un administrador</h1>
	* Se encarga de modelar todas las funcionalidades que realiza el administrador de la app
	* @version 1.0
	* @author Juan Pablo Araque, Nicolás Ávila, Sebastián Moncaleano, Diego Torres | Universidad El Bosque
	 */
public class Administrador {
	
	
	
	/**
	 * El método generarPDFReporteUsuario se encarga de generar un archivo PDF con el historial
	 * de compras realizadas de una tarjeta de crédito
	 * <b>pre</b> File archivo  =! null <br>
	 * <b>pre</b> Long numCredit  =! null  <br>
	 * <b>pre</b> ArrayList<String>base debe estar inicializada =! null  <br>
	 * <b>post</b> Se ha generado el registro de compras asociadas a la tarjeta de crédito en formato PDF <br>
	 * @param archivo ruta del archivo donde se guardará el pdf
	 * @param base base de datos del cliente al cual se le generará el reporte en PDF
	 * @param numCredit numero de tarjeta de crédito de datos del cliente al cual se le generará el reporte en PDF
	 */
	
	public void generarPDFReporteUsuario(File archivo, ArrayList<String>base,  Long numCredit) {
		try {
					PdfWriter escribe = new PdfWriter(archivo);
					PdfDocument pdf = new PdfDocument(escribe);
					Document docu = new Document (pdf, PageSize.A4.rotate());
					docu.setMargins(20, 20, 20, 20);
					PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA);
					PdfFont bold = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
					Table table = new Table(new float[] {6,6,6,6,6,6});
					table.setWidthPercent(80);
					docu.add(new Paragraph("REPORTE HIDE & SEEK").setFont(font));
					docu.add(new Paragraph("El historial de sus compras es: ").setFont(font));
					String linea = "FECHA;HORA;DÍA;MONTO;LUGAR DE COMPRA;TARJETA DE CRÉDITO";
					procesarDatos(table, linea, bold, true);
					for (int i = 0; i < base.size(); i++) {
						String linea1 = base.get(i);
						
						String [] aux = linea1.split(";");
						long num = Long.parseLong(aux[5]);
						String lineaa= aux[0]+";"+aux[1]+";"+aux[2]+";"+aux[3]+";"+aux[4]+";"+aux[5];
						if (num == numCredit) {
							procesarDatos(table, lineaa, font, false);
						} 
						
						
					}
					docu.add(table);
					docu.close();
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}
	
	/**
	 * El método generarPDFEstadisticas se encarga de generar un archivo PDF con las estadísticas de
	 * moda, mediana y media 
	 * <b>pre</b> File archivo =! null <br>
	 * <b>pre</b> String tipo  =! null  <br>
	 * <b>pre</b> ArrayList<String>base debe estar inicializada =! null  <br>
	 * <b>post</b> Se ha generado el PDF que contiene las estadísticas de media, moda y mediana <br>
	 * @param archivo ruta del archivo donde se guardará el pdf
	 * @param base ArrayList donde se encuentran las estadísticas
	 * @param tipo tipo de estadísticas que se consignan el PDF. Están en el encabezado de la tabla
	 */


	public void generarPDFEstadisticas(File archivo,  ArrayList<String>base, String tipo) {
		 
	    try {
			PdfWriter escribe = new PdfWriter(archivo);
			PdfDocument pdf = new PdfDocument(escribe);
			Document docu = new Document (pdf, PageSize.A4.rotate());
			docu.setMargins(20, 20, 20, 20);
			PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA);
			PdfFont bold = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
			Table table = new Table(new float[] {6,6,6,6});
			table.setWidthPercent(50);
			docu.add(new Paragraph("REPORTE HIDE & SEEK"));
			docu.add(new Paragraph("ESTADÍSTICAS"));
			String linea = tipo+";" + "MEDIANA;MODA;MEDIA";
			procesarDatos(table, linea, bold, true);
			for (int i = 1; i < base.size(); i++) {
				String linea1 = base.get(i);
				procesarDatos(table, linea1, font, false);
				
			}
			docu.add(table);
			docu.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * El método procesarDatos se encarga de generar y rellenar una tabla
	 * <b>pre</b> Table table debe estar inicializada  =! null <br>
	 * <b>pre</b> String lineal  =! null  <br>
	 * <b>post</b> Se ha generado una tabla con los datos suministrados<br>
	 * @param table tabla donde se tabularán los datos
	 * @param linea string de valores separados por ";", que contiene los datos.
	 * @param font fuente de la letra de la tabla
	 * @param isHeader valor booleano que nos indica si la linea que llega debería de ir en el encabezado
	 */
	public void procesarDatos(Table table, String linea, PdfFont font, boolean isHeader) {
		StringTokenizer token = new StringTokenizer(linea, ";");
		while (token.hasMoreElements()) {
			if (isHeader) {
				table.addHeaderCell(new Cell().add(new Paragraph(token.nextToken()).setFont(font)));
			} else {
				table.addCell(new Cell().add(new Paragraph(token.nextToken()).setFont(font)));
			}
			
		}
		
		
	}
	
	/**
	 * El método de rutaPDF nos proporciona una ventana JFileChooser para darnos a elegir
	 * la ruta y el nombre con el que queremos guardar el pdf
	 * @return ruta y nombre del archivo pdf que guardaremos
	 */
	public File rutaPDF() {
		JFileChooser guardar = new JFileChooser();
	    guardar.showSaveDialog(null);
	    guardar.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		String ruta = guardar.getSelectedFile()+".pdf";
		File archivo = new File (ruta);
		
		return archivo;
	}
	
	/**
	 * El método valorVentas registra el valor de cada una de las ventas en un listado
	 * <b>pre</b> ArrayList<String>registros debe estar inicializada =! null  <br>
	 * <b>post</b> Se ha generado el listado <br>
	 * @param registros listado de las compras que se han realizado en la app
	 * @param fecha fecha de la cual se quiere conocer las ventas realizadas
	 * @return listado con los precios de las ventas realizadas
	 */
	
	public double[] valorVentas(ArrayList<String> registros, Date fecha) {
		double []ventas = new double[registros.size()];
		for (int i = 0; i < registros.size(); i++) {
			String []dat = registros.get(i).split(";");
			String f = dat[0];
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String fechaI = sdf.format(fecha);
			if(fechaI.equalsIgnoreCase(f)) {
				String debito = dat[3];
				double deb = Double.parseDouble(debito);
				ventas[i] = deb;
			}
		}
		return ventas;
	}
	
	/**
	 * Este método calcula la media de ventas realizadas
	 * <b>pre</b> double[]ventas debe estar inicializada =! null  <br>
	 * <b>post</b> Se ha calculado la media <br>
	 * @param ventas listado de todas las ventas realizadas
	 * @return la media de las ventas realizadas
	 */
	
	public double media(double []ventas) {
		double media = 0.0;
		double suma = 0.0;
		int cant = ventas.length;
		for (int i = 0; i < ventas.length; i++) {
			suma = suma + ventas[i];
		}
		media = suma/cant;
		return media;
	}
	
	/**
	 * Este método calcula la moda de ventas realizadas
	 * <b>pre</b> double[]ventas debe estar inicializada =! null  <br>
	 * <b>post</b> Se ha calculado la moda <br>
	 * @param ventas listado de todas las ventas realizadas
	 * @return la moda de las ventas realizadas
	 */
	
	public double moda(double []ventas) {
		double moda = 0.0;
		int maxNumRepeticiones = 0;
		for (int i = 0; i < ventas.length; i++) {
			int numRepeticiones = 0;
			for (int j = 0; j < ventas.length; j++) {
				if(ventas[j] == ventas[i]) {
					numRepeticiones++;
				}
				if(numRepeticiones > maxNumRepeticiones) {
					maxNumRepeticiones = numRepeticiones;
					moda = ventas[i];
				}
			}
		}
		return moda;
	}
	
	/**
	 * Este método calcula la mediana de ventas realizadas
	 * <b>pre</b> double[]ventas debe estar inicializada =! null  <br>
	 * <b>post</b> Se ha calculado la mediana <br>
	 * @param ventas listado de todas las ventas realizadas
	 * @return la mediana de las ventas realizadas
	 */
	
	public double mediana(double []ventas) {
		double mediana = 0.0;
		int medio = ventas.length/2;
		if(ventas.length%2 == 1) {
			mediana = ventas[medio];
		} else {
			mediana = (ventas[medio-1] + ventas[medio])/2.0;
		}
		return mediana;
	}
	
	/**
	 * Metodo que convierte un String de una fecha en un Date
	 * @param fechaE fecha en String, separada con formato "dd/MM/yyyy"
	 * <b>pre</b> fechaE debe estar  separada con formato "dd/MM/yyyy" <br>
	 * <b>post</b> Se ha transformado la fecha a Date <br>
	 * @return fecha de tipo Date
	 */
	
	public Date convertirFecha(String fechaE) {
		String fe = fechaE;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date fecha;
		try {
			fecha = sdf.parse(fe);
			return fecha;
		}
		catch(ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Metodo que genera un listado con todas las estadisticas de una fecha en especifico
	 * <b>pre</b> ArrayList<String>ventas debe estar inicializada =! null  <br>
	 * <b>post</b> Se ha generado el listado <br>
	 * @param registros listado de las compras que se han realizado en la app
	 * @param fecha fecha de la cual se quiere conocer las estadisticas de las ventas realizadas* @return
	 */
	
	public ArrayList<String> generarArregloEstadisticas(ArrayList<String> ventas,String fecha){
		double[] ventasE=valorVentas(ventas,convertirFecha(fecha));
		ArrayList<String> estadisticas= new ArrayList<String>();
		String media= String.valueOf(media(ventasE));
		String mediana= String.valueOf(mediana(ventasE));
		String moda= String.valueOf(moda(ventasE));
		estadisticas.add(mediana);
		estadisticas.add(media);
		estadisticas.add(moda);
		return estadisticas;
	}
	
	/**
	 * Metodo que enlista las ventas en una semana en especifco
	 * <b>pre</b> ArrayList<String>ventas debe estar inicializada =! null  <br>
	 * <b>post</b> Se ha generado el listado <br>
	 * @param ventas listado de las ventas realizadas en la aplicaación
	 * @param f1 fecha desde donde se quieren las ventas 
	 * @param f2 fecha hasta donde se quieren las ventas
	 * @return un listado de las ventas que se realizaron en esa semana específica
	 */
	public ArrayList<String> ventasPorSemana(ArrayList<String> ventas, String f1, String f2) {
		ArrayList<String> ventasSemana = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date fechaI = sdf.parse(f1);
			Date fechaF = sdf.parse(f2);
			long dias = (fechaF.getTime()-fechaI.getTime())/86400000;
			System.out.println(dias);
			if(dias==7) {
				for (int i = 0; i < ventas.size(); i++) {
					String []dat=ventas.get(i).split(";");
					String f = dat[0];
					Date fecha = sdf.parse(f);
					if(fecha.after(fechaI) & fecha.before(fechaF)) {
						String deb = dat[3];
						ventasSemana.add(deb);
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "Una semana dura 7 dias", "Cantidad dias",JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return ventasSemana;
	}
	
	/**
	 * Metodo que genera una factura con las compras realizadas
	 * <b>pre</b> ArrayList<String>base debe estar inicializada =! null  <br>
	 * <b>post</b> Se ha generado la factura <br>
	 * @param base listado de compras realizadas
	 * @param creditCard tarjeta de credito que realizó la compra
	 * @param monto dinero total de la compra
	 * @return nombre de la factura en string si se generó, o un "no se generó" en caso contrario
	 */
	
	public String generarPDFFactura(ArrayList<String>base, Long creditCard, double monto) {
		File carpeta = new File("./facturas");
		long leftLimit = 1L;
		long rightLimit = 99999999999999L;
		long generatedLong = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
		String numeroDeFactura = "FACTURA#" + generatedLong+".pdf";
		if(!carpeta.isDirectory()) {
			carpeta.mkdir();
		}
		File archivo = new File("facturas/"+numeroDeFactura);
	    try {
			PdfWriter escribe = new PdfWriter(archivo);
			PdfDocument pdf = new PdfDocument(escribe);
			Document docu = new Document (pdf, PageSize.A4.rotate());
			docu.setMargins(20, 20, 20, 20);
			PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA);
			PdfFont bold = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
			Table table = new Table(new float[] {6,6,6});
			table.setWidthPercent(70);
			docu.add(new Paragraph("REPORTE HIDE & SEEK"));
			docu.add(new Paragraph("Factura electrónica realizada por la tarteja #" + creditCard + "\n" + "Monto total: " + monto));
			String linea = "PRODUCTO"+";" + "CANTIDAD;PRECIO";
			procesarDatos(table, linea, bold, true);
			for (int i = 1; i < base.size(); i++) {
				String linea1 = base.get(i);
				procesarDatos(table, linea1, font, false);
				
			}
			docu.add(table);
			docu.close();
			return numeroDeFactura;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "no se generó";
	}
	
}

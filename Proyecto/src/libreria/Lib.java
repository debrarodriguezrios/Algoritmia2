package libreria;

import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import arreglos.ArregloCines;
import clases.Cine;
import gui.Proyecto;

import javax.swing.JTextArea;

public class Lib {
	//  Atributos static 
	public static String tiposDeEmpleado[] = { "Administrador", "Supervisor", "Cajero", "Carné" };
	public static String tiposDeEstadocivil[] = { "Soltero", "Casado", "Viudo", "Divorciado" };
	public static String tiposDeCine[] = { "Standar", "Prime" };
	public static int numSala[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
	public static int numFila[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21,
			22, 23, 24, 25};
	public static int numButaca[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18,19,20
			
	
	
	};
	
	//  Métodos static tipo void con parámetros
	public static void mensajeError(JDialog jd, String s) {
		JOptionPane.showMessageDialog(jd, s, "Error",
				                      JOptionPane.ERROR_MESSAGE);
	}
	public static void mensajeAdvertencia(JDialog jd, String s) {
		JOptionPane.showMessageDialog(jd, s, "Advertencia",
				                      JOptionPane.WARNING_MESSAGE);
	}
	public static void mensajeInformacion(JDialog jd, String s) {
		JOptionPane.showMessageDialog(jd, s, "Información",
				                      JOptionPane.INFORMATION_MESSAGE);
	}
	public static void soloLetras(KeyEvent e, JTextField txt, int maximo) {
	 	char  x = e.getKeyChar();
	 	if (Character.isDigit(x)  &&  x != ' ')
	 		e.consume();
       	if (txt.getText().length() == maximo)
       		e.consume();
    }
    public static void soloNumeros(KeyEvent e, JTextField txt, int maximo) {
    	char  x = e.getKeyChar();	 
	 	if (!Character.isDigit(x))
			e.consume();
       	if (txt.getText().length() == maximo)
			e.consume();
    }
	//  Métodos static que retornan valor con parámetros
	public static int confirmacion(JDialog jd, String s) {
		return JOptionPane.showConfirmDialog(jd, s, "Advertencia",
			   JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
	}
	public static String formatoFecha(int fecha) {
		String s = fecha%100 + " de ";
		fecha /= 100;
		switch (fecha%100) {
			case 1:
				s += "Enero";
				break;
			case 2:
				s += "Febrero";
				break;
			case 3:
				s += "Marzo";
				break;
			case 4:
				s += "Abril";
				break;
			case 5:
				s += "Mayo";
				break;
			case 6:
				s += "Junio";
				break;
			case 7:
				s += "Julio";
				break;
			case 8:
				s += "Agosto";
				break;
			case 9:
				s += "Setiembre";
				break;
			case 10:
				s += "Octubre";
				break;
			case 11:
				s += "Noviembre";
				break;
			default:
				s += "Diciembre";
				break;
		}
		s = s + " de " + fecha / 100;
		return s;
	}
	public static String leerCadena(JTextField txt) {
		return txt.getText().trim();
	}
	public static String leerCadenaGrande(JTextArea txt) {
		return txt.getText().trim();
	}
	public static int leerEntero(JTextField txt) {
		try {
			return Integer.parseInt(txt.getText().trim());
		}
		catch (Exception e) {
			return  -1;
		}
	}
	public static int leerEntero(JComboBox <String> jComboBox) {
		try {
			return Integer.parseInt((String)jComboBox.getSelectedItem());
		}
		catch (Exception e) {
			return  -1;
		}
	}
	public static int leerEntero(JLabel lbl) {
		try {
			return Integer.parseInt(lbl.getText().trim());
		}
		catch (Exception e) {
			return  -1;
		}
	}
	public static double leerReal(JTextField txt) {
		try {
			return Double.parseDouble(txt.getText().trim());
		}
		catch (Exception e) {
			return -1.0;
		}
	}
	public static String leerEstado(JRadioButton rdb) {
		if (rdb.isSelected())
			return "Activo";
		else
			return "No Activo";
	}
	
	public static String formatoFecha(String dia, String mes, String año, String formato) throws Exception {
		String fechaFormato = null;
		try{
			
			LocalDate today = LocalDate.of(Integer.parseInt(año), obtenerMes(mes), Integer.parseInt(dia));
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        fechaFormato = formatter.format(today);
		}catch(Exception e){
			throw new Exception("El valor "+dia+", "+mes+", "+año+", no es una fecha valida");
		}
		return fechaFormato;
	}
	
	public static Integer obtenerMes(String mesCadena) throws Exception{
		if ("Enero".equalsIgnoreCase(mesCadena)){
			return 1;
		}else if ("Febrero".equalsIgnoreCase(mesCadena)){
			return 2;
		}else if ("Marzo".equalsIgnoreCase(mesCadena)){
			return 3;
		}else if ("Abril".equalsIgnoreCase(mesCadena)){
			return 4;
		}else if ("Mayo".equalsIgnoreCase(mesCadena)){
			return 5;
		}else if ("Junio".equalsIgnoreCase(mesCadena)){
			return 6;
		}else if ("Julio".equalsIgnoreCase(mesCadena)){
			return 7;
		}else if ("Agosto".equalsIgnoreCase(mesCadena)){
			return 8;
		}else if ("Setiembre".equalsIgnoreCase(mesCadena)){
			return 9;
		}else if ("Octubre".equalsIgnoreCase(mesCadena)){
			return 10;
		}else if ("Noviembre".equalsIgnoreCase(mesCadena)){
			return 11;
		}else if ("Diciembre".equalsIgnoreCase(mesCadena)){
			return 12;
		}else{
			throw new Exception("El valor "+mesCadena+", no es un mes valido...");
		}
	}
	
	public static void colocarCines(JComboBox <String> jComboBox){
		ArrayList <Cine> arregloCines = Proyecto.aci.getCines();
		for (Cine cine : arregloCines) {
			jComboBox.addItem(String.valueOf(cine.getCodigocine()));
		}
	}
}
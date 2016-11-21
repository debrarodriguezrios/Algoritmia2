package libreria;

import java.awt.event.KeyEvent;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Lib {
	//  Atributos static 
	public static String tiposDeID[] = { "DNI", "RUC", "Pasaporte", "Carné", "Carné de extranjería" };
	public static String tiposDeArea[] = { "Finanzas", "Administración", "Recursos Humanos", "Soporte",
		                                   "Logística", "Marketing" };
	public static String tiposDeEstado[] = { "No activo", "Activo" };
	public static String tiposDeIncidencia[] = { "Registrada", "Iniciada", "Cancelada", "Cerrada"};
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
	
}

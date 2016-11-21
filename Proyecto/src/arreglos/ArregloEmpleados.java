package arreglos;

import clases.Empleado;



import libreria.*;

import java.io.*;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ArregloEmpleados extends AbstractTableModel{
	
	    private static final long serialVersionUID = 1L;
	    
	    //Atributos Privados
		private ArrayList <Empleado> emp;
		
		//Constructor
		public ArregloEmpleados (){
			emp = new ArrayList <Empleado> ();
			cargarEmpleado();
		
		}
		//Operaciones Públicas
		public int tamaño (){
			return emp.size();
		}
		public Empleado obtener (int e){
			return emp.get(e);
		}
		
		public void adicionar(Empleado x) {		  
			emp.add(x);	
			fireTableDataChanged();
		}
		
		public Empleado buscar(int codigo) {
			Empleado x;
			for (int i=0; i<tamaño(); i++) {
				x = obtener(i);
				if (x.getCodigoEmpleado() == codigo)
					return x;
			}
			return null;		
		}
		
		public void eliminar(Empleado x) {
			emp.remove(x);
			fireTableDataChanged();
		}
		
		private void cargarEmpleado() {
			try {			
				BufferedReader br;
				String linea, nombres, apellidopaterno, apellidomaterno, usuario, contrasena;
				String[] s;
				int codigoempleado, tipoempleado;
				br = new BufferedReader(new FileReader("empleados.txt"));
				while ((linea = br.readLine()) != null) {
					s = linea.split(";");
					codigoempleado = Integer.parseInt(s[0].trim());
					nombres = s[1].trim();
					apellidopaterno = s[2].trim();
					apellidomaterno = s[3].trim();
					tipoempleado = Integer.parseInt(s[4].trim());
					usuario = s[5].trim();								
					contrasena = s[6].trim();
					adicionar(new Empleado(codigoempleado,nombres,apellidopaterno,apellidomaterno,tipoempleado,
							              usuario,contrasena));
				}			
				br.close();
			}		
			catch (Exception e) {
			}
		}	
		
		public void grabarEmpleado() {
			try {
				PrintWriter pw;
				Empleado x;
				pw = new PrintWriter(new FileWriter("empleados.txt"));
				for (int i=0; i<tamaño(); i++) {
					x = obtener(i);
					pw.println(x.getCodigoEmpleado() + ";" + 
					           x.getNombres() + ";" +
							   x.getApellidoPaterno() + ";" +
					           x.getApellidoMaterno() + ";" +
					           x.getTipoEmpleado() + ";" +
					           x.getUsuario() + ";" +
					           x.getContraseña() + ";" );				
				}
				pw.close();
			}
			catch (Exception e) {
			}
		}	
		
		
		public int generarCodigo() {
			if (tamaño() == 0)
				return 10001;
			else
				return obtener(tamaño()-1).getCodigoEmpleado() + 1;
		}
		
	//  Métodos redefinidos de la clase AbstractTableModel
		private String nombreColumnas[] = { "CÓDIGO DE EMPLEADO", "NOMBRES", 
				                            "APELLIDO PATERNO", "APELLIDO MATERNO",
				                            "TIPO DE EMPLEADO", "USUARIO",
				                            "CONTRASEÑA" };
		
		public int getRowCount() {
			return emp.size();
		}	
		public int getColumnCount() {
			return nombreColumnas.length;
		}	
		public String getColumnName(int columna) {
			return nombreColumnas[columna];
		}
		
		public Object getValueAt(int fila, int columna) {
			Empleado x = obtener(fila);
			switch (columna) {
				case 0:
					return x.getCodigoEmpleado();
				case 1:
					return x.getNombres();
				case 2:
					return x.getApellidoPaterno();
				case 3:
					return x.getApellidoMaterno();
				case 4:
					return Lib.tiposDeEmpleado[x.getTipoEmpleado()];
				case 5:
					return x.getUsuario();
				default:
					return x.getContraseña();
			}
		}
		

}

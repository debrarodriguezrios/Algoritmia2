package arreglos;

import clases.Cliente;



import libreria.*;

import java.io.*;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ArregloClientes extends AbstractTableModel{
	
    private static final long serialVersionUID = 1L;
    
    //Atributos Privados
	private ArrayList <Cliente> cli;
	
	//Constructor
	public ArregloClientes (){
		cli = new ArrayList <Cliente> ();
		cargarCliente();
	
	}
	//Operaciones Públicas
	public int tamaño (){
		return cli.size();
	}
	public Cliente obtener (int e){
		return cli.get(e);
	}
	
	public void adicionar(Cliente x) {		  
		cli.add(x);	
		fireTableDataChanged();
	}
	
	public Cliente buscar(int codigo) {
		Cliente x;
		for (int i=0; i<tamaño(); i++) {
			x = obtener(i);
			if (x.getCodigocliente() == codigo)
				return x;
		}
		return null;		
	}
	
	public void eliminar(Cliente x) {
		cli.remove(x);
		fireTableDataChanged();
	}
	
	private void cargarCliente() {
		try {			
			BufferedReader br;
			String linea, nombres, apellidopaterno, apellidomaterno, direccion, fechanac,
			fechaafil, telefono, dni, usuario, contrasena;
			String[] s;
			int codigocliente, estadocivil;
			br = new BufferedReader(new FileReader("cliente.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigocliente = Integer.parseInt(s[0].trim());
				nombres = s[1].trim();
				apellidopaterno = s[2].trim();
				apellidomaterno = s[3].trim();
				direccion = s[4].trim();
				fechanac = s[5].trim();
				fechaafil = s[6].trim();
				estadocivil = Integer.parseInt(s[7].trim());
				telefono = s[8].trim();
				dni = s[9].trim();
				usuario = s[10].trim();								
				contrasena = s[11].trim();
				adicionar(new Cliente(codigocliente,nombres,apellidopaterno,apellidomaterno,
							direccion, fechanac, fechaafil, estadocivil, telefono, dni,
						    usuario,contrasena));
			}			
			br.close();
		}		
		catch (Exception e) {
		}
	}	
	
	public void grabarCliente() {
		try {
			PrintWriter pw;
			Cliente x;
			pw = new PrintWriter(new FileWriter("cliente.txt"));
			for (int i=0; i<tamaño(); i++) {
				x = obtener(i);
				pw.println(x.getCodigocliente() + ";" + 
				           x.getNombres() + ";" +
						   x.getApellidoPaterno() + ";" +
				           x.getApellidoMaterno() + ";" +
				           x.getDireccion() + ";" +
				           x.getFechanac() + ";" +
				           x.getFechaafil() + ";" +
				           x.getEstadocivil() + ";" +
				           x.getTelefono() + ";" +
				           x.getDni() + ";" +
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
			return obtener(tamaño()-1).getCodigocliente() + 1;
	}
	
//  Métodos redefinidos de la clase AbstractTableModel
	private String nombreColumnas[] = { "CÓDIGO DE CLIENTE", "NOMBRES", 
			                            "APELLIDO PATERNO", "APELLIDO MATERNO",
			                            "DIRECCION", "FECHA DE NACIMIENTO", "FECHA DE AFILIACION",
			                            "ESTADO CIVIL", "TELEFONO","DNI", "USUARIO",
			                            "CONTRASEÑA" };
	
	public int getRowCount() {
		return cli.size();
	}	
	public int getColumnCount() {
		return nombreColumnas.length;
	}	
	public String getColumnName(int columna) {
		return nombreColumnas[columna];
	}
	
	public Object getValueAt(int fila, int columna) {
		Cliente x = obtener(fila);
		switch (columna) {
			case 0:
				return x.getCodigocliente();
			case 1:
				return x.getNombres();
			case 2:
				return x.getApellidoPaterno();
			case 3:
				return x.getApellidoMaterno();
			case 4:
				return x.getDireccion();
			case 5:
				return x.getFechanac();
			case 6:
				return x.getFechaafil();
			case 7:
				return Lib.tiposDeEstadocivil[x.getEstadocivil()];
			case 8:
				return x.getTelefono();
			case 9:
				return x.getDni();
			case 10:
				return x.getUsuario();
			default:
				return x.getContraseña();
		}
	}
	

}

package arreglos;
import clases.Cine;

import libreria.*;

import java.io.*;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
public class ArregloCines extends AbstractTableModel{
	
    private static final long serialVersionUID = 1L;
    
    //Atributos Privados
	private ArrayList <Cine> cin;
	
	//Constructor
	public ArregloCines (){
		cin = new ArrayList <Cine> ();
		cargarCine();
	
	}
	//Operaciones Públicas
	public int tamaño (){
		return cin.size();
	}
	public Cine obtener (int e){
		return cin.get(e);
	}
	
	public void adicionar(Cine x) {		  
		cin.add(x);	
		fireTableDataChanged();
	}
	
	public Cine buscar(int codigo) {
		Cine x;
		for (int i=0; i<tamaño(); i++) {
			x = obtener(i);
			if (x.getCodigocine() == codigo)
				return x;
		}
		return null;		
	}
	
	public void eliminar(Cine x) {
		cin.remove(x);
		fireTableDataChanged();
	}
	
	private void cargarCine() {
		try {			
			BufferedReader br;
			String linea, nombre, departamento, provincia, distrito, fechainicio;
			String[] s;
			int codigocine, tipocine;
			br = new BufferedReader(new FileReader("cine.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigocine = Integer.parseInt(s[0].trim());
				nombre = s[1].trim();
				departamento = s[2].trim();
				provincia = s[3].trim();
				distrito = s[4].trim();								
				fechainicio = s[5].trim();
				tipocine = Integer.parseInt(s[6].trim());
				adicionar(new Cine(codigocine,nombre,departamento,provincia,distrito,
						              fechainicio,tipocine));
			}			
			br.close();
		}		
		catch (Exception e) {
		}
	}	
	
	public void grabarCine() {
		try {
			PrintWriter pw;
			Cine x;
			pw = new PrintWriter(new FileWriter("cines.txt"));
			for (int i=0; i<tamaño(); i++) {
				x = obtener(i);
				pw.println(x.getCodigocine() + ";" + 
				           x.getNombre() + ";" +
						   x.getDepartamento() + ";" +
				           x.getProvincia() + ";" +
				           x.getDistrito() + ";" +
				           x.getFechainicio() + ";" +
				           x.getTipocine() + ";" );				
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
			return obtener(tamaño()-1).getCodigocine() + 1;
	}
	
//  Métodos redefinidos de la clase AbstractTableModel
	private String nombreColumnas[] = { "CÓDIGO DE CINE", "NOMBRE", 
			                            "DEPARTAMENTO", "PROVINCIA",
			                            "DISTRITO", "FECHA DE INICIO DE OPERACIONES",
			                            "TIPO DE CINE" };
	
	public int getRowCount() {
		return cin.size();
	}	
	public int getColumnCount() {
		return nombreColumnas.length;
	}	
	public String getColumnName(int columna) {
		return nombreColumnas[columna];
	}
	
	public Object getValueAt(int fila, int columna) {
		Cine x = obtener(fila);
		switch (columna) {
			case 0:
				return x.getCodigocine();
			case 1:
				return x.getNombre();
			case 2:
				return x.getDepartamento();
			case 3:
				return x.getProvincia();
			case 4:
				return x.getDistrito(); 
			case 5:
				return x.getFechainicio();
			default:
				return Lib.tiposDeCine[x.getTipocine()];
		}
	}
	
	public ArrayList<Cine> getCines() {
		return cin;
	}

}

package arreglos;
import clases.Butaca;

import libreria.*;

import java.io.*;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
public class ArregloButacas extends AbstractTableModel{
	
    private static final long serialVersionUID = 1L;
    
    //Atributos Privados
	private ArrayList <Butaca> but;
	
	//Constructor
	public ArregloButacas (){
		but = new ArrayList <Butaca> ();
		cargarCine();
	
	}
	//Operaciones Públicas
	public int tamaño (){
		return but.size();
	}
	public Butaca obtener (int e){
		return but.get(e);
	}
	
	public void adicionar(Butaca x) {		  
		but.add(x);	
		fireTableDataChanged();
	}
	
	public Butaca buscar(int codigo) {
		Butaca x;
		for (int i=0; i<tamaño(); i++) {
			x = obtener(i);
			if (x.getCodigoButaca() == codigo)
				return x;
		}
		return null;		
	}
	
	public void eliminar(Butaca x) {
		but.remove(x);
		fireTableDataChanged();
	}
	
	private void cargarCine() {
		try {			
			BufferedReader br;
			String linea;
			String[] s;
			int codigobutaca, codigosala, numfila, numcolumna, estado;
			br = new BufferedReader(new FileReader("butacas.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigobutaca = Integer.parseInt(s[0].trim());
				codigosala = Integer.parseInt(s[1].trim());
				numfila = Integer.parseInt(s[2].trim());
				numcolumna = Integer.parseInt(s[3].trim());
				estado = Integer.parseInt(s[4].trim());
				adicionar(new Butaca(codigobutaca,codigosala,numfila,numcolumna, estado));
			}			
			br.close();
		}		
		catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	public void grabarButaca() {
		try {
			PrintWriter pw;
			Butaca x;
			pw = new PrintWriter(new FileWriter("butacas.txt"));
			for (int i=0; i<tamaño(); i++) {
				x = obtener(i);
				pw.println(x.getCodigoButaca() + ";" + 
				           x.getCodigoSala() + ";" +
						   x.getNumfila() + ";" +
				           x.getNumcolumna() + ";" +
				           x.getEstado() + ";" );				
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
			return obtener(tamaño()-1).getCodigoButaca() + 1;
	}
	
//  Métodos redefinidos de la clase AbstractTableModel
	private String nombreColumnas[] = { "CÓDIGO DE BUTACA", "CÓDIGO DE SALA", 
			                            "NÚMERO DE FILA", "NÚMERO DE COLUMNA",
			                            "ESTADO" };
	
	public int getRowCount() {
		return but.size();
	}	
	public int getColumnCount() {
		return nombreColumnas.length;
	}	
	public String getColumnName(int columna) {
		return nombreColumnas[columna];
	}
	
	public Object getValueAt(int fila, int columna) {
		Butaca x = obtener(fila);
		switch (columna) {
			case 0:
				return x.getCodigoButaca();
			case 1:
				return x.getCodigoSala();
			case 2:
				return x.getNumfila();
			case 3:
				return x.getNumcolumna();
			default:
				return Lib.estadoDeButaca[x.getEstado()];
		}
	}
	
	public ArrayList<Butaca> getButacas() {
		return but;
	}

}

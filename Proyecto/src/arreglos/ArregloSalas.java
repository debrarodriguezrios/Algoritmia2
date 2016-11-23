package arreglos;
import clases.Sala;





import java.io.*;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
public class ArregloSalas extends AbstractTableModel{
	
    private static final long serialVersionUID = 1L;
    
    //Atributos Privados
	private ArrayList <Sala> sal;
	
	//Constructor
	public ArregloSalas (){
		sal = new ArrayList <Sala> ();
		cargarSala();
	
	}
	//Operaciones Públicas
	public int tamaño (){
		return sal.size();
	}
	public Sala obtener (int e){
		return sal.get(e);
	}
	
	public void adicionar(Sala x) {		  
		sal.add(x);	
		fireTableDataChanged();
	}
	
	public Sala buscar(int codigo) {
		Sala x;
		for (int i=0; i<tamaño(); i++) {
			x = obtener(i);
			if (x.getCodigosala() == codigo)
				return x;
		}
		return null;		
	}
	
	public void eliminar(Sala x) {
		sal.remove(x);
		fireTableDataChanged();
	}
	
	private void cargarSala() {
		try {			
			BufferedReader br;
			String linea;
			String[] s;
			int codigosala, codigocine,numsala,numfila,numbutaca;
			br = new BufferedReader(new FileReader("sala.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigosala = Integer.parseInt(s[0].trim());
				codigocine = Integer.parseInt(s[1].trim());
				numsala = Integer.parseInt(s[2].trim());
				numfila = Integer.parseInt(s[3].trim());
				numbutaca = Integer.parseInt(s[4].trim());
				
				adicionar(new Sala(codigosala,codigocine,numsala,numfila,numbutaca));
			}			
			br.close();
		}		
		catch (Exception e) {
		}
	}	
	
	public void grabarSala() {
		try {
			PrintWriter pw;
			Sala x;
			pw = new PrintWriter(new FileWriter("Salas.txt"));
			for (int i=0; i<tamaño(); i++) {
				x = obtener(i);
				pw.println(x.getCodigosala() + ";" + 
				           x.getCodigocine() + ";" +
						   x.getNumsala() + ";" +
				           x.getNumfila() + ";" +
				           x.getNumbutaca() + ";" );				
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
			return obtener(tamaño()-1).getCodigosala() + 1;
	}
	
//  Métodos redefinidos de la clase AbstractTableModel
	private String nombreColumnas[] = { "CÓDIGO DE SALA", "CÓDIGO DE CINE", 
			                            "NUMERO DE SALA", "NUMERO DE FILA",
			                            "NUMERO DE BUTACA" };
	
	public int getRowCount() {
		return sal.size();
	}	
	public int getColumnCount() {
		return nombreColumnas.length;
	}	
	public String getColumnName(int columna) {
		return nombreColumnas[columna];
	}
	
	public Object getValueAt(int fila, int columna) {
		Sala x = obtener(fila);
		switch (columna) {
			case 0:
				return x.getCodigosala();
			default:
				return x.getCodigocine();
			
			
		}
	}

}

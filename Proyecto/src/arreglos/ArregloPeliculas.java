package arreglos;
import clases.Pelicula;

import libreria.*;

import java.io.*;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
public class ArregloPeliculas extends AbstractTableModel{
	
    private static final long serialVersionUID = 1L;
    
    //Atributos Privados
	private ArrayList <Pelicula> pel;
	
	//Constructor
	public ArregloPeliculas (){
		pel = new ArrayList <Pelicula> ();
		cargarPelicula();
	
	}
	//Operaciones Públicas
	public int tamaño (){
		return pel.size();
	}
	public Pelicula obtener (int e){
		return pel.get(e);
	}
	
	public void adicionar(Pelicula x) {		  
		pel.add(x);	
		fireTableDataChanged();
	}
	
	public Pelicula buscar(int codigo) {
		Pelicula x;
		for (int i=0; i<tamaño(); i++) {
			x = obtener(i);
			if (x.getCodigopelicula() == codigo)
				return x;
		}
		return null;		
	}
	
	public void eliminar(Pelicula x) {
		pel.remove(x);
		fireTableDataChanged();
	}
	
	private void cargarPelicula() {
		try {			
			BufferedReader br;
			String linea, titdistrib, titoriginal, fechaestreno, genero, paisorigen, sinopsis;
			String[] s;
			int codigopelicula, tipoproyeccion, duracion, tipocensura, estadoproyeccion;
			double recaudacion;
			br = new BufferedReader(new FileReader("cines.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigopelicula = Integer.parseInt(s[0].trim());
				titdistrib = s[1].trim();
				titoriginal = s[2].trim();
				fechaestreno = s[3].trim();
				tipoproyeccion = Integer.parseInt(s[4].trim()); 								
				genero = s[5].trim();
				paisorigen = s[6].trim();
				sinopsis = s[7].trim();
				duracion = Integer.parseInt(s[8].trim());
				tipocensura = Integer.parseInt(s[9].trim());
				estadoproyeccion = Integer.parseInt(s[10].trim());
				recaudacion = Double.parseDouble(s[11].trim());
				adicionar(new Pelicula(codigopelicula,titdistrib,titoriginal,fechaestreno,tipoproyeccion,genero,paisorigen,
						sinopsis,duracion,tipocensura,estadoproyeccion,recaudacion));
			}			
			br.close();
		}		
		catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	public void grabarPelicula() {
		try {
			PrintWriter pw;
			Pelicula x;
			pw = new PrintWriter(new FileWriter("peliculas.txt"));
			for (int i=0; i<tamaño(); i++) {
				x = obtener(i);
				pw.println(x.getCodigopelicula() + ";" + 
				           x.getTitdistrib() + ";" +
						   x.getTitoriginal() + ";" +
				           x.getFechaestreno() + ";" +
				           x.getTipoproyeccion() + ";" +
				           x.getGenero() + ";" +
				           x.getPaisorigen() + ";" +
						   x.getSinopsis() + ";" +
						   x.getDuracion() + ";" +
						   x.getTipocensura() + ";" +
						   x.getEstadoproyeccion() + ";" +
						   x.getRecaudacion() + ";" );
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
			return obtener(tamaño()-1).getCodigopelicula() + 1;
	}
	
//  Métodos redefinidos de la clase AbstractTableModel
	private String nombreColumnas[] = { "CÓDIGO DE PELÍCULA", "TÍTULO DE DISTRIBUCIÓN", 
			                            "TÍTULO ORIGINAL", "FECHA DE ESTRENO",
			                            "TIPO DE PROYECCION", "GÉNERO","PAÍS DE ORIGEN","SINOPSIS","DURACIÓN",
			                            "TIPO DE CENSURA","ESTADO DE PROYECCIÓN","RECAUDACIÓN" };
	
	public int getRowCount() {
		return pel.size();
	}	
	public int getColumnCount() {
		return nombreColumnas.length;
	}	
	public String getColumnName(int columna) {
		return nombreColumnas[columna];
	}
	
	public Object getValueAt(int fila, int columna) {
		Pelicula x = obtener(fila);
		switch (columna) {
			case 0:
				return x.getCodigopelicula();
			case 1:
				return x.getTitdistrib();
			case 2:
				return x.getTitoriginal();
			case 3:
				return x.getFechaestreno();
			case 4:
				return Lib.tipoDeProyeccion[x.getTipoproyeccion()]; 
			case 5:
				return x.getGenero();
			case 6:
				return x.getPaisorigen();
			case 7:
				return x.getSinopsis();
			case 8:
				return x.getDuracion();
			case 9:
				return Lib.tipoDeCensura[x.getTipocensura()];
			case 10:
				return Lib.estadoDeProyeccion[x.getEstadoproyeccion()];
			default:
				return x.getRecaudacion();
		}
	}
	
	public ArrayList<Pelicula> getCines() {
		return pel;
	}

}

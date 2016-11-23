package clases;

public class Butaca {
	//Atributos Privados
			private int codigobutaca, codigosala, numfila, numcolumna, estado;
			
			
			//Constructor
			public Butaca (int codigocine, int codigosala, int numfila, int numcolumna, int estado){
					this.codigobutaca = codigobutaca;
					this.codigosala = codigosala;
					this.numfila = numfila;
					this.numcolumna = numcolumna;
					this.estado = estado;
			}
			
			//Métodos de Acceso Público: Set/Get
			public void setCodigoButaca (int codigobutaca){
				this.codigobutaca = codigobutaca;
			}
			public void setCodigoSala (int codigosala){
				this.codigosala = codigosala;
			}
			public void setNumFila (int numfila){
				this.numfila = numfila;
			}
			public void setNumColumna (int numcolumna){
				this.numcolumna = numcolumna;
			}
			public void setEstado (int estado){
				this.estado = estado;
			}
			
			public int getCodigoButaca (){
				return codigobutaca;
			}
			public int getCodigoSala(){
				return codigosala;
			}
			public int getNumfila(){
				return numfila;
			}
			public int getNumcolumna(){
				return numcolumna;
			}
			public int getEstado (){
				return estado;
			}
		
}

package clases;

public class Sala {
	//Atributos Privados
			private int codigosala, codigocine, numsala, numfila, numbutaca;
			
			
			//Constructor
			public Sala (int codigosala, int codigocine, int numsala, int numfila, int numbutaca){
					this.codigosala = codigosala;
					this.codigocine = codigocine;
					this.numsala = numsala;
					this.numfila = numfila;
					this.numbutaca = numbutaca;
					
			}
			
			//Métodos de Acceso Público: Set/Get
			public void setCodigosala (int codigosala){
				this.codigosala = codigosala;
			}
			public void setCodigocine (int codigocine){
				this.codigocine = codigocine;
			}
			public void setNumsala (int numsala){
				this.numsala = numsala;
			}
			public void setNumfila (int numfila){
				this.numfila = numfila;
			}
			public void setNumbutaca (int numbutaca){
				this.numbutaca = numbutaca;
			}
						
			
			public int getCodigosala (){
				return codigosala;
			}
			public int getCodigocine (){
				return codigocine;
			}
			public int getNumsala (){
				return numsala;
			}
			public int getNumfila (){
				return numfila;
			}
			public int getNumbutaca (){
				return numbutaca;
			}
		
}

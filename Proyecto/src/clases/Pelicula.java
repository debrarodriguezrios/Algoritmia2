package clases;

public class Pelicula {
	//Atributos Privados
			private int codigopelicula, tipoproyeccion, duracion, tipocensura, estadoproyeccion;
			private String titdistrib, titoriginal, fechaestreno, genero, paisorigen, sinopsis;
			private double recaudacion;
			
			//Constructor
			public Pelicula (int codigopelicula, String titdistrib, String titoriginal, 
					String fechaestreno, int tipoproyeccion, String genero, String paisorigen, 
					String sinopsis, int duracion, int tipocensura, int estadoproyeccion, double recaudacion){
					this.codigopelicula = codigopelicula;
					this.titdistrib = titdistrib;
					this.titoriginal = titoriginal;
					this.fechaestreno = fechaestreno;
					this.tipoproyeccion = tipoproyeccion;
					this.genero = genero;
					this.paisorigen = paisorigen;
					this.sinopsis = sinopsis;
					this.duracion = duracion;
					this.tipocensura = tipocensura;
					this.estadoproyeccion = estadoproyeccion;
					this.recaudacion = recaudacion;
			}
			
			//Métodos de Acceso Público: Set/Get
			public void setCodigopelicula (int codigocine){
				this.codigopelicula = codigocine;
			}
			public void setTitdistrib (String titdistrib){
				this.titdistrib = titdistrib;
			}
			public void setTitoriginal (String titoriginal){
				this.titoriginal = titoriginal;
			}
			public void setFechaestreno (String fechaestreno){
				this.fechaestreno = fechaestreno;
			}
			public void setTipoproyeccion (int tipoproyeccion){
				this.tipoproyeccion = tipoproyeccion;
			}
			public void setGenero (String genero){
				this.genero = genero;
			}
			public void setPaisorigen (String paisorigen){
				this.paisorigen = paisorigen;
			}
			public void setSinopsis (String sinopsis){
				this.sinopsis = sinopsis;
			}
			public void setDuracion (int duracion){
				this.duracion = duracion;
			}
			public void setTipocensura (int tipocensura){
				this.tipocensura = tipocensura;
			}
			public void setEstadoproyeccion (int estadoproyeccion){
				this.estadoproyeccion = estadoproyeccion;
			}
			public void setRecaudacion (double recaudacion){
				this.recaudacion = recaudacion;
			}
			public int getCodigopelicula (){
				return codigopelicula;
			}
			public String getTitdistrib (){
				return titdistrib;
			}
			public String getTitoriginal (){
				return titoriginal;
			}
			public String getFechaestreno (){
				return fechaestreno;
			}
			public int getTipoproyeccion (){
				return tipoproyeccion;
			}
			public String getGenero (){
				return genero;
			}
			public String getPaisorigen(){
				return paisorigen;
			}
			public String getSinopsis(){
				return sinopsis;
			}
			public int getDuracion(){
				return duracion;
			}
			public int getTipocensura (){
				return tipocensura;
			}
			public int getEstadoproyeccion (){
				return estadoproyeccion;
			}
			public double getRecaudacion(){
				return recaudacion;
			}
		
}

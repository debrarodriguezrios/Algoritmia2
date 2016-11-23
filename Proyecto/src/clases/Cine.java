package clases;

public class Cine {
	//Atributos Privados
			private int codigocine, tipocine;
			private String nombre, departamento, provincia, distrito, fechainicio;
			
			//Constructor
			public Cine (int codigocine, String nombre, String departamento, 
					String provincia, String distrito, String fechainicio, int tipocine){
					this.codigocine = codigocine;
					this.nombre = nombre;
					this.departamento = departamento;
					this.provincia = provincia;
					this.distrito = distrito;
					this.fechainicio = fechainicio;
					this.tipocine = tipocine;
			}
			
			//Métodos de Acceso Público: Set/Get
			public void setCodigoCine (int codigocine){
				this.codigocine = codigocine;
			}
			public void setNombre (String nombre){
				this.nombre = nombre;
			}
			public void setDepartamento (String departamento){
				this.departamento = departamento;
			}
			public void setProvincia (String provincia){
				this.provincia = provincia;
			}
			public void setDistrito (String distrito){
				this.distrito = distrito;
			}
			public void setFechainicio (String fechainicio){
				this.fechainicio = fechainicio;
			}
			public void setTipocine (int tipocine){
				this.tipocine = tipocine;
			}
			
			public int getCodigocine (){
				return codigocine;
			}
			public String getNombre (){
				return nombre;
			}
			public String getDepartamento (){
				return departamento;
			}
			public String getProvincia (){
				return provincia;
			}
			public String getDistrito (){
				return distrito;
			}
			public String getFechainicio (){
				return fechainicio;
			}
			public int getTipocine (){
				return tipocine;
			}
		
}

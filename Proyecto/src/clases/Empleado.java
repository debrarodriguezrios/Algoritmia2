package clases;

public class Empleado {

	//Atributos Privados
		private int codigoempleado, tipoempleado;
		private String nombres, apellidopaterno, apellidomaterno, usuario, contraseña;
		
		//Constructor
		public Empleado (int codigoempleado, String nombres, String apellidopaterno, 
				String apellidomaterno, int tipoempleado, String usuario, String contraseña){
				this.codigoempleado = codigoempleado;
				this.nombres = nombres;
				this.apellidopaterno = apellidopaterno;
				this.apellidomaterno = apellidomaterno;
				this.tipoempleado = tipoempleado;
				this.usuario = usuario;
				this.contraseña = contraseña;
		}
		
		//Métodos de Acceso Público: Set/Get
		public void setCodigoEmpleado (int codigoempleado){
			this.codigoempleado = codigoempleado;
		}
		public void setNombres (String nombres){
			this.nombres = nombres;
		}
		public void setApellidoPaterno (String apellidopaterno){
			this.apellidopaterno = apellidopaterno;
		}
		public void setApellidoMaterno (String apellidomaterno){
			this.apellidomaterno = apellidomaterno;
		}
		public void setTipoEmpleado (int tipoempleado){
			this.tipoempleado = tipoempleado;
		}
		public void setUsuario (String usuario){
			this.usuario = usuario;
		}
		public void setContraseña (String contraseña){
			this.contraseña = contraseña;
		}
		
		
		public int getCodigoEmpleado (){
			return codigoempleado;
		}
		public String getNombres (){
			return nombres;
		}
		public String getApellidoPaterno (){
			return apellidopaterno;
		}
		public String getApellidoMaterno (){
			return apellidomaterno;
		}
		public int getTipoEmpleado (){
			return tipoempleado;
		}
		public String getUsuario (){
			return usuario;
		}
		public String getContraseña (){
			return contraseña;
		}
	
}

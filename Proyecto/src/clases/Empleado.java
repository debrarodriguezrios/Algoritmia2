package clases;

public class Empleado {

	//Atributos Privados
		private int codigoempleado, tipoempleado;
		private String nombres, apellidopaterno, apellidomaterno, usuario, contrase�a;
		
		//Constructor
		public Empleado (int codigoempleado, String nombres, String apellidopaterno, 
				String apellidomaterno, int tipoempleado, String usuario, String contrase�a){
				this.codigoempleado = codigoempleado;
				this.nombres = nombres;
				this.apellidopaterno = apellidopaterno;
				this.apellidomaterno = apellidomaterno;
				this.tipoempleado = tipoempleado;
				this.usuario = usuario;
				this.contrase�a = contrase�a;
		}
		
		//M�todos de Acceso P�blico: Set/Get
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
		public void setContrase�a (String contrase�a){
			this.contrase�a = contrase�a;
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
		public String getContrase�a (){
			return contrase�a;
		}
	
}

package clases;

public class Cliente {
	//Atributos Privados
			private int codigocliente, estadocivil;
			private String nombres, apellidopaterno, apellidomaterno, direccion, fechanac, fechaafil, telefono, dni, usuario, contraseña;
			
			//Constructor
			public Cliente (int codigocliente, String nombres, String apellidopaterno, 
					String apellidomaterno, String direccion, String fechanac, String fechaafil, int estadocivil, String telefono, String dni, String usuario, String contraseña){
					this.codigocliente = codigocliente;
					this.nombres = nombres;
					this.apellidopaterno = apellidopaterno;
					this.apellidomaterno = apellidomaterno;
					this.direccion = direccion;
					this.fechanac = fechanac;
					this.fechaafil = fechaafil;
					this.estadocivil = estadocivil;
					this.telefono = telefono;
					this.dni = dni;
					this.usuario = usuario;
					this.contraseña = contraseña;
			}
			
			//Métodos de Acceso Público: Set/Get
			public void setCodigoCliente (int codigocliente){
				this.codigocliente = codigocliente;
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
			public void setDireccion (String direccion){
				this.direccion=direccion;
			}
			public void setFechanac (String fechanac){
				this.fechanac=fechanac;
			}
			public void setFechaafil (String fechaafil){
				this.fechaafil=fechaafil;
			}
			public void setEstadocivil (int estadocivil){
				this.estadocivil = estadocivil;
			}
			public void setTelefono (String telefono){
				this.telefono=telefono;
			}
			public void setDni (String dni){
				this.dni=dni;
			}
			public void setUsuario (String usuario){
				this.usuario = usuario;
			}
			public void setContraseña (String contraseña){
				this.contraseña = contraseña;
			}
			
			
			public int getCodigocliente (){
				return codigocliente;
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
			public String getDireccion(){
				return direccion;
			}
			public String getFechanac(){
				return fechanac;
			}
			public String getFechaafil(){
				return fechaafil;
			}
			public int getEstadocivil (){
				return estadocivil;
			}
			public String getTelefono(){
				return telefono;
			}
			public String getDni(){
				return dni;
			}
			public String getUsuario (){
				return usuario;
			}
			public String getContraseña (){
				return contraseña;
			}
		
		
}

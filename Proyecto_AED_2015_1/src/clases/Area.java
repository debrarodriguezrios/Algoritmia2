package clases;

public class Area {
	//  Atributos privados	
	private int codigo, estado;
	private String nombre, descripcion, nombreCorto, nombreLargo;
	//  Constructor
	public Area(int codigo, String nombre, String descripcion, 
				String nombreCorto, String nombreLargo, int estado) {
		this.codigo = codigo;		
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.nombreCorto = nombreCorto;
		this.nombreLargo = nombreLargo;
		this.estado = estado;
	}	
	//  M�todos de acceso p�blico: set/get 
	public void setCodigo(int codigo) {			
		this.codigo = codigo;	    	 
	}
	public void setNombre(String nombre) {			
		this.nombre = nombre;	    	 
	} 
	public void setDescripcion(String descripcion) {		
		this.descripcion = descripcion;	    	 
	}   
    public void setNombreCorto(String nombreCorto) {   	
    	this.nombreCorto = nombreCorto;	    	 
    }
    public void setNombreLargo(String nombreLargo) {	   	
    	this.nombreLargo = nombreLargo;	    	 
    }   
    public void setEstado(int estado) {    
    	this.estado = estado;	    	 
    }
	public int getCodigo() {	   	 		
		return codigo;	    	 
	}
	public String getNombre() {
		return nombre;
	}  
    public String getDescripcion() {    	
    	return descripcion;    	
    }
    public String getNombreCorto() {   	
    	return nombreCorto;
    }
    public String getNombreLargo() {    	
    	return nombreLargo;	
    }
    public int getEstado() {    	
    	return estado;    	
    } 
}

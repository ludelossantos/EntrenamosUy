package logica;


public class InstitucionDeportiva {
	private String nombre;
	private String descripcion;
	private String url;
	
	//CONSTRUCTORES
	
	public InstitucionDeportiva() {
		super();
	}
	
	public InstitucionDeportiva(String nombre, String descripcion, String url) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.url = url;
	}


	// GETTERS & SETTERS
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}


	//METODOS
	
}

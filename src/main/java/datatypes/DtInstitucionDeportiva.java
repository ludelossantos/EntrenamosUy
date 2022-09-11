package datatypes;

public class DtInstitucionDeportiva {
	private String nombre;
	private String descripcion;
	private String url;
	
	//CONSTRUCTORES
	public DtInstitucionDeportiva() {
		super();
	}

	public DtInstitucionDeportiva(String nombre, String descripcion, String url) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.url = url;
	}

	//GETTERS
	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getUrl() {
		return url;
	}

	
	
	

}
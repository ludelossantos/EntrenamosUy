package datatypes;

public class DtActividadDeportiva {
	private String nombre;
	private String descripcion;
	
	public DtActividadDeportiva() {
		super();
	}

	public DtActividadDeportiva(String nombre, String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
}
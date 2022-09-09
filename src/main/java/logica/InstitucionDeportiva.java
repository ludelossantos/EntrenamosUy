package logica;

import javax.persistence.Entity;
import javax.persistence.Id;

import antlr.collections.List;


@Entity
public class InstitucionDeportiva {
	@Id
	private String nombre;
	private String descripcion;
	private String url;
	
	//@onetomany_actDepor()
	
	//private List<ActividadDeportiva>actividadesDeportivas;
	
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

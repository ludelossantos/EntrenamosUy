package logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import datatypes.DtActividadDeportiva;

@Entity
public class InstitucionDeportiva {
	@Id
	private String nombre;
	private String descripcion;
	private String url;
	
	@OneToMany(mappedBy = "institucion",cascade = CascadeType.ALL)
	private List<Profesor> profesores = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<ActividadDeportiva> actividades = new ArrayList<>();
	
	
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
	/*
	public ArrayList<DtActividadDeportiva> obtenerActividades(){
		ArrayList<DtActividadDeportiva> lista = new ArrayList<>();
		for(ActividadDeportiva a : actividades) {
			lista.add(a.getDtActividadDeportiva());
		}
		return lista;
	}
	
	public ActividadDeportiva buscarActividad(String nombre) {
		ActividadDeportiva actividad = null;
		for(ActividadDeportiva a : actividades) {
			if(a.getNombre().equals(nombre))
				actividad = a;
		}
		return actividad;
	}
	
	public void agregarActividadDeportiva(ActividadDeportiva actividad) {
		actividades.add(actividad);
	}
	
	public ArrayList<ActividadDeportiva> obtenerActividadesObjeto(){
		ArrayList<ActividadDeportiva> lista = new ArrayList<>();
		for(ActividadDeportiva a : actividades) {
			lista.add(a);
		}
		return lista;
	}
	*/
}

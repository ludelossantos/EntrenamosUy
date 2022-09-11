package logica;

import java.util.ArrayList;
import java.util.List;

import datatypes.DtActividadDeportiva;

public class InstitucionDeportiva {
	private String nombre;
	private String descripcion;
	private String url;
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
	
	public ArrayList<DtActividadDeportiva> obtenerActividades(){
		ArrayList<DtActividadDeportiva> lista = new ArrayList<>();
		for(ActividadDeportiva a : this.actividades) {
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
	
	public void agregarActividad(ActividadDeportiva actividad) {
		actividades.add(actividad);
	}
	
}

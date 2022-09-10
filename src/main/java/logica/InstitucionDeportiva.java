package logica;

import java.util.ArrayList;
import java.util.List;

public class  InstitucionDeportiva{
	private String nombre;
	private String descripcion;
	private String url;
	private ArrayList<ActividadDeportiva> actividades = new ArrayList<>();
	
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


	
	//MANEJO DE ACTIVIDADES DEPORTIVAS

	public void agregarActividad(ActividadDeportiva Actividad) {
		actividades.add(Actividad);
	}
	
	public ActividadDeportiva obtenerActividad(String nombre) {
		ActividadDeportiva aretornar = null;
		for(ActividadDeportiva a: actividades) {
			if(a.getNombre().equals(nombre))
				aretornar = a;
		}
		return aretornar;
	}
	
	public ArrayList<ActividadDeportiva> obtenerActividadesObjeto() {
		return this.actividades;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public List<ActividadDeportiva> getActividades() {
//		return actividades;
//	}
//
//
//
//
//	public void setActividades(List<ActividadDeportiva> actividades) {
//		this.actividades = actividades;
//	}


	//METODOS
	
}

package logica;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;

import datatypes.DtActividadDeportiva;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import datatypes.DtActividadDeportiva;
import persistencia.Conexion;


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

	public ActividadDeportiva buscarActividad(String nombre) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		ActividadDeportiva actividad = em.find(ActividadDeportiva.class, nombre);
		return actividad;
	}

	public void agregarActividadDeportiva(ActividadDeportiva actividad) {
		actividades.add(actividad);
	}
	
	public ArrayList<DtActividadDeportiva> obtenerActividades(){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		javax.persistence.Query query = em.createQuery("select a from ActividadDeportiva a");
		List<ActividadDeportiva> actividades = (List<ActividadDeportiva>) query.getResultList();
		ArrayList<DtActividadDeportiva> lista = new ArrayList<>();
		for(ActividadDeportiva a : actividades) {
			lista.add(a.getDtActividadDeportiva());
		}
		return lista;
	}

	public ArrayList<ActividadDeportiva> obtenerActividadesObjeto(){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		javax.persistence.Query query = em.createQuery("select a from ActividadDeportiva a");
		List<ActividadDeportiva> actividades = (List<ActividadDeportiva>) query.getResultList();
		ArrayList<ActividadDeportiva> lista = new ArrayList<>();
		for(ActividadDeportiva a : actividades) {
			lista.add(a);
		}
		return lista;
	}		
	
}

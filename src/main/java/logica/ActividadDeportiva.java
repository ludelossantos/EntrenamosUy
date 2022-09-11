package logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.util.Date;

import datatypes.DtActividadDeportiva;
import datatypes.DtClase;
import persistencia.Conexion;

@Entity
public class ActividadDeportiva {
	@Id
	private String nombre;
	private String descripcion;
	private int duracion;
	private float costo;
	private Date fechaReg;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Clase> clases = new ArrayList<>();
	
	//CONSTRUCTORES
	public ActividadDeportiva() {
		super();
	}

	public ActividadDeportiva(String nombre, String descripcion, int duracion, float costo, Date fechaReg) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.costo = costo;
		this.fechaReg = fechaReg;
	}
	
	//GETTERS & SETTERS
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

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	public Date getFechaReg() {
		return fechaReg;
	}

	public void setFechaReg(Date fechaReg) {
		this.fechaReg = fechaReg;
	}

	public DtActividadDeportiva getDtActividadDeportiva() {
		return new DtActividadDeportiva(nombre,descripcion, duracion, costo, fechaReg);
	}
	
	// METODOS
	public void agregarClase(Clase clase) {
		this.clases.add(clase);
	}
	
	public Clase buscarClase(String nombre) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Clase clase = em.find(Clase.class, nombre);
		return clase;
	}	
	
	public ArrayList<DtClase> obtenerClases(){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		javax.persistence.Query query = em.createQuery("select a from Clase a");
		List<Clase> clases = (List<Clase>) query.getResultList();
		ArrayList<DtClase> listado = new ArrayList<>();
		for(Clase c: clases) {
			listado.add(c.getDtClase());
		}
		return listado;
	}
	
	public ArrayList<Clase> obtenerClasesObjeto(){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		javax.persistence.Query query = em.createQuery("select a from Clase a");
		List<Clase> clases = (List<Clase>) query.getResultList();
		ArrayList<Clase> listado = new ArrayList<>();
		for(Clase c: clases) {
			listado.add(c);
		}
		return listado;
	}
}

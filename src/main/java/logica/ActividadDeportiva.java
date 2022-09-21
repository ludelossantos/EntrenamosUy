package logica;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import datatypes.DtActividadDeportiva;
import datatypes.DtClase;
import persistencia.Conexion;
import java.math.BigDecimal;


@Entity
public class ActividadDeportiva {
	@Id
	private String nombre;
	private String descripcion;
	private Float duracion;
	private BigDecimal costo;
	private Date fechaReg;

	@ManyToOne
	private InstitucionDeportiva institucion;
	
	
	//@OneToMany(cascade = CascadeType.ALL)
	@OneToMany(mappedBy = "actividad", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Clase> clases = new ArrayList<>();
	
	//CONSTRUCTORES
	public ActividadDeportiva() {
		super();
	}

	public ActividadDeportiva(String nombre, String descripcion, Float duracion, BigDecimal costo, Date fechaReg, InstitucionDeportiva institucion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.costo = costo;
		this.fechaReg = fechaReg;
		this.institucion = institucion;
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

	public Float getDuracion() {
		return duracion;
	}

	public void setDuracion(Float duracion) {
		this.duracion = duracion;
	}

	public BigDecimal getCosto() {
		return costo;
	}

	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}

	public Date getFechaReg() {
		return fechaReg;
	}

	public void setFechaReg(Date fechaReg) {
		this.fechaReg = fechaReg;
	}

	public DtActividadDeportiva getDtActividadDeportiva() {
		//return new DtActividadDeportiva(this.getNombre(), this.getDescripcion(), this.getDuracion(), this.getCosto(), this.getFechaReg());
		return new DtActividadDeportiva(this.nombre, this.descripcion, this.duracion, this.costo, this.fechaReg);
	}

	// METODOS
	public void agregarClase(Clase clase) {
		this.clases.add(clase);
	}

	public Clase buscarClase(String nombre) {
		/*Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Clase clase = em.find(Clase.class, nombre);
		return clase;*/
		for(Clase c : clases) {
			if(c.getNombre().equals(nombre))
				return c;
		}
		return null;
	}	
	
	public ArrayList<DtClase> obtenerClases(){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		//javax.persistence.Query query = em.createQuery("select a from Clase a");
		//List<Clase> clases = (List<Clase>) query.getResultList();
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
	
	public DtActividadDeportiva getDtActividadDeportivaMaxi() {
		//Conexion conexion = Conexion.getInstancia();
		//EntityManager em = conexion.getEntityManager();
		//javax.persistence.Query query = em.createQuery("select c from Clase c");
		//List<Clase> clases = (List<Clase>) query.getResultList();
		List<String> listadoClases = new ArrayList<>();
		for(Clase c: clases) {
			listadoClases.add(c.getNombre());
		}
		return new DtActividadDeportiva(nombre,descripcion, duracion, costo, fechaReg, listadoClases);
	}
	/*
	public DtActividadDeportiva getDtActividadDeportivaMaxi2(String nickname) {
		//Conexion conexion = Conexion.getInstancia();
		//EntityManager em = conexion.getEntityManager();
		//javax.persistence.Query query = em.createQuery("select c from Clase c");
		//List<Clase> clases = (List<Clase>) query.getResultList();
		List<String> listadoClases = new ArrayList<>();
		for(Clase c: clases) {
			if(c.getProfesor().getNickname().equals(nickname)) {
				System.out.println(c.getProfesor().getNickname());
				System.out.println(nickname);
				listadoClases.add(c.getNombre());
			}
		}
		return new DtActividadDeportiva(nombre,descripcion, duracion, costo, fechaReg, listadoClases);
	}*/

}
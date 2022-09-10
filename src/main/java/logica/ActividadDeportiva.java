package logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.util.Date;

import datatypes.DtActividadDeportiva;
import datatypes.DtClase;

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
	/*
	public DtActividadDeportiva getDtActividadDeportiva() {
		return new DtActividadDeportiva(nombre,descripcion);
	}
	
	public void agregarClase(Clase clase) {
		this.clases.add(clase);
	}
	
	public Clase buscarClase(String nombre) {
		Clase clase = null;
		for(Clase c : clases) {
			if(c.getNombre().equals(nombre))
				clase = c;
		}
		return clase;
	}
	
	public ArrayList<DtClase> obtenerClases(){
		ArrayList<DtClase> listado = new ArrayList<>();
		for(Clase c: clases) {
			listado.add(c.getDtClase());
		}
		return listado;
	}
	
	public ArrayList<Clase> obtenerClasesObjeto(){
		ArrayList<Clase> listado = new ArrayList<>();
		for(Clase c: clases) {
			listado.add(c);
		}
		return listado;
	}*/
}

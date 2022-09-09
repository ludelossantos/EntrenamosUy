package logica;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import datatypes.DtActividadDeportiva;

public class ActividadDeportiva {
	private String nombre;
	private String descripcion;
	private Float duracion;
	private BigDecimal costo;
	private Date fechaReg;
	private List<Clase> clases = new ArrayList<>();
	
	public ActividadDeportiva() {
		super();
	}

	public ActividadDeportiva(String nombre, String descripcion, Float duracion, BigDecimal costo, Date fechaReg) {
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
}

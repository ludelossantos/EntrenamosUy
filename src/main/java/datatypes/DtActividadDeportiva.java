package datatypes;

import java.util.Date;

public class DtActividadDeportiva {
	private String nombre;
	private String descripcion;
	private int duracion;
	private float costo;
	private Date fechaReg;
	
	public DtActividadDeportiva() {
		super();
	}

	public DtActividadDeportiva(String nombre, String descripcion, int duracion, float costo, Date fechaReg) {
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

	public String getDescripcion() {
		return descripcion;
	}

	public int getDuracion() {
		return duracion;
	}

	public float getCosto() {
		return costo;
	}

	public Date getFechaReg() {
		return fechaReg;
	}
	
}
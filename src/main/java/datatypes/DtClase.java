package datatypes;

import java.sql.Time;
import java.util.Date;

public class DtClase {
	private String nombre;
	private Date fecha;
	private Date horaInicio;
	private String url;
	private Date fechaReg;
	private String actividad;
	private String nickProfesor;
	private String nomInstitucion;
	
	public DtClase() {
		super();
	}

	public DtClase(String nombre, Date fecha, Date horaInicio, String url, Date fechaReg, String actividad, String nickProfesor, String nomInstitucion) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.url = url;
		this.fechaReg = fechaReg;
		this.actividad = actividad;
		this.nickProfesor = nickProfesor;
		this.nomInstitucion = nomInstitucion;
	}

	public DtClase(String nombre, Date fecha, Date horaInicio2, String url, Date fechaReg) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.horaInicio = horaInicio2;
		this.url = url;
		this.fechaReg = fechaReg;
	}
	
	public String getNombre() {
		return nombre;
	}

	public Date getFecha() {
		return fecha;
	}

	public Date getHoraInicio() {
		return horaInicio;
	}

	public String getUrl() {
		return url;
	}

	public Date getFechaReg() {
		return fechaReg;
	}
	
	public String getActividad() {
		return actividad;
	}
	
	public String getNomInstitucion() {
		return nomInstitucion;
	}
	
	public String getNickProfesor() {
		return nickProfesor;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public void setFechaReg(Date fechaReg) {
		this.fechaReg = fechaReg;
	}
}

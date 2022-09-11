package datatypes;

import java.sql.Time;
import java.util.Date;

public class DtClase {
	private String nombre;
	private Date fecha;
	private Time horaInicio;
	private String url;
	private Date fechaReg;
	private String nomActividad;
	private String nomInstitucion;
	private String nickProfesor;
	
	public DtClase() {
		super();
	}

	public DtClase(String nombre, Date fecha, Time horaInicio, String url, Date fechaReg, String nomActividad, String nickProfesor, String nomInstitucion) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.url = url;
		this.fechaReg = fechaReg;
		this.nomActividad = nomActividad;
		this.nickProfesor = nickProfesor;
		this.nomInstitucion = nomInstitucion;
	}

	public String getNombre() {
		return nombre;
	}

	public Date getFecha() {
		return fecha;
	}

	public Time getHoraInicio() {
		return horaInicio;
	}

	public String getUrl() {
		return url;
	}

	public Date getFechaReg() {
		return fechaReg;
	}
	
	public String getNomActividad() {
		return nomActividad;
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

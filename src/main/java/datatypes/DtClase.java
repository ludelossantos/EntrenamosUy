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
	private String nickProfesor;
	private String nomInstitucion;
	
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
	
	public String getNickProfesor() {
		return nickProfesor;
	}
	
	public String getNomInstitucion() {
		return nomInstitucion;
	}
}

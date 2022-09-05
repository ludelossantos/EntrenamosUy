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

	public DtClase(String nombre, Date fecha, Time horaInicio, String url, Date fechaReg) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.url = url;
		this.fechaReg = fechaReg;
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
}

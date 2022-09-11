package logica;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import datatypes.DtClase;

@Entity
public class Clase {
	@Id
	private String nombre;
	private Date fecha;
	private Time horaInicio;
	private String url;
	private Date fechaReg;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Registro> sociosRegistrados = new ArrayList<>();
	
	public Clase() {
		super();
	}

	public Clase(String nombre, Date fecha, Time horaInicio, String url, Date fechaReg) {
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

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Time getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getFechaReg() {
		return fechaReg;
	}

	public void setFechaReg(Date fechaReg) {
		this.fechaReg = fechaReg;
	}
	
	public DtClase getDtClase() {
		return new DtClase(nombre, fecha, horaInicio, url, fechaReg);
	}

	public void agregarRegistro(Registro registro) {
		sociosRegistrados.add(registro);
	}
}

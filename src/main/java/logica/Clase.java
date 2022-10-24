package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import datatypes.DtClase;

@Entity
public class Clase {
	@Id
	private String nombre;
	private Date fecha;
	private Date horaInicio;
	private String url;
	private Date fechaReg;
	private String foto;
	
	@ManyToOne
	private ActividadDeportiva actividad;
	
	@ManyToOne
	private Profesor profesor;
	
	@OneToMany(mappedBy = "clase", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Registro> sociosRegistrados = new ArrayList<>();
	
	//CONSTRUCTORES
	public Clase() {
		super();
	}

	public Clase(String nombre, Date fecha, Date horaInicio, String url, Date fechaReg, ActividadDeportiva actividad, Profesor profesor) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.url = url;
		this.fechaReg = fechaReg;
		this.actividad = actividad;
		this.profesor = profesor;
	}
	public Clase(String nombre, Date fecha, Date horaInicio, String url, Date fechaReg, ActividadDeportiva actividad, Profesor profesor, String foto) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.url = url;
		this.fechaReg = fechaReg;
		this.actividad = actividad;
		this.profesor = profesor;
		this.foto = foto;
	}

	//GETTERS Y SETTERS
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

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
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
	
	public Profesor getProfesor() {
		return profesor;
	}
	
	public ActividadDeportiva getActividad() {
		return actividad;
	}

	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}

	public DtClase getDtClase() {
		return new DtClase(nombre, fecha, horaInicio, url, fechaReg, profesor.getNickname());
	}
	
	public DtClase getDtClaseFoto() {
        return new DtClase(nombre, fecha, horaInicio, url, fechaReg, profesor.getNickname(), foto);
    }

	//METODOS
	public void agregarRegistro(Registro registro) {
		sociosRegistrados.add(registro);
	}
}

package logica;

import java.util.Date;

public class Registro {
	private Socio socio;
	private Clase clase;
	private Date fechaReg;

	public Registro() {
		super();
	}

	public Registro(Socio socio, Clase clase, Date fechaReg) {
		super();
		this.socio = socio;
		this.clase = clase;
		this.fechaReg = fechaReg;
		
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public Clase getClase() {
		return clase;
	}

	public void setClase(Clase clase) {
		this.clase = clase;
	}

	public Date getFechaReg() {
		return fechaReg;
	}

	public void setFechaReg(Date fechaReg) {
		this.fechaReg = fechaReg;
	}
	
	
}

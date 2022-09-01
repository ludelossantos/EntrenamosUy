package logica;

import java.util.Date;

public class Registro {
	private Date fechaReg;

	public Registro() {
		super();
	}

	public Registro(Date fechaReg) {
		super();
		this.fechaReg = fechaReg;
	}

	public Date getFechaReg() {
		return fechaReg;
	}

	public void setFechaReg(Date fechaReg) {
		this.fechaReg = fechaReg;
	}
	
	
}

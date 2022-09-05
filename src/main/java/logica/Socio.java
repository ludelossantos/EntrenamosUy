package logica;

import java.util.Date;

import datatypes.DtSocio;
import datatypes.DtUsuario;

public class Socio extends Usuario {
	private Clase clase;

	public Socio() {
		super();
	}

	public Socio(String nickname, String nombre, String apellido, String email, Date fechaNac) {
		super(nickname, nombre, apellido, email, fechaNac);
	}
	
	public Socio(String nickname, String nombre, String apellido, String email, Date fechaNac, Clase clase) {
		super(nickname, nombre, apellido, email, fechaNac);
		this.clase = clase;
	}

	public Clase getClase() {
		return clase;
	}

	public void setClase(Clase clase) {
		this.clase = clase;
	}

	public DtUsuario getDtUsuario() {
		// TODO Auto-generated method stub
		return new DtSocio(this.getNickname(),this.getNombre(),this.getApellido(),this.getEmail(),this.getFechaNac());
	}
	
}

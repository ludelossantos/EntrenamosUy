package datatypes;

import java.util.Date;

import logica.Clase;

public class DtSocio extends DtUsuario {
	Clase clase;

	public DtSocio() {
		super();
	}

	public DtSocio(String nickname, String nombre, String apellido, String email, Date fechaNac) {
		super(nickname, nombre, apellido, email, fechaNac);
	}
	
	
	public DtSocio(String nickname, String nombre, String apellido, String email, Date fechaNac, String pass) {
		super(nickname, nombre, apellido, email, fechaNac, pass);
	}
	
	public DtSocio(String nickname, String nombre, String apellido, String email, Date fechaNac, Clase clase) {
		super(nickname, nombre, apellido, email, fechaNac);
		this.clase = clase;
	}

	public Clase getClase() {
		return clase;
	}
	

}

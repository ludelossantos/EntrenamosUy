package logica;

import java.util.Date;

public class Socio extends Usuario {

	public Socio() {
		super();
	}

	public Socio(String nickname, String nombre, String apellido, String email, Date fechaNac) {
		super(nickname, nombre, apellido, email, fechaNac);
	}
	
}

package logica;

import java.util.ArrayList;
import java.util.Date;

import datatypes.DtClase;
import datatypes.DtSocio;

public class Socio extends Usuario {
	
	private ArrayList<Registro> clasesRegistradas = new ArrayList<>();
	
	public Socio() {
		super();
	}

	public Socio(String nickname, String nombre, String apellido, String email, Date fechaNac) {
		super(nickname, nombre, apellido, email, fechaNac);
	}
	
	public void agregarRegistro(Registro registro) {
		clasesRegistradas.add(registro);
	}
	
	public ArrayList<DtClase> obtenerClases(){
		ArrayList<DtClase> lista = new ArrayList<>();
		for(Registro c: clasesRegistradas) {
				lista.add(c.getClase().getDtClase());
		}
		return lista;
	}
	
	public DtSocio getDtSocio() {
		return new DtSocio(this.getNickname(), this.getNombre(), this.getApellido(), this.getEmail(), this.getFechaNac());
	}
}

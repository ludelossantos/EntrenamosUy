package logica;

import java.util.ArrayList;
import java.util.Date;

public class Socio extends Usuario {
	
	private ArrayList<Clase> clasesRegistradas; 
	
	public Socio() {
		super();
	}

	public Socio(String nickname, String nombre, String apellido, String email, Date fechaNac) {
		super(nickname, nombre, apellido, email, fechaNac);
	}
	
	public ArrayList<Clase> obtenerClases(){
		ArrayList<Clase> lista = new ArrayList<>();
		for(Clase c: clasesRegistradas) {
			lista.add(c);
		}
		return lista;
	}
	
	public void agregarClase(Clase clase) {
		this.clasesRegistradas.add(clase);
	}
	
}

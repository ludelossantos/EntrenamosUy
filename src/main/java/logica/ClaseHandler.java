package logica;

import java.util.ArrayList;
import java.util.List;

import javafx.util.Pair;

public class ClaseHandler {
	private static ClaseHandler instancia = null;
	private List<Clase> clases = new ArrayList<>();
	private Pair<String,String> pair;
	
	private ClaseHandler() {}
	
	public static ClaseHandler getInstancia() {
		if(instancia == null)
			instancia = new ClaseHandler();
		return instancia;
	}

	public ArrayList<Pair<String,String>> obtenerClasesActividad(String actividad){
		ArrayList<Pair<String,String>> listado = new ArrayList<>();
		for(Clase c: clases) {
			if(actividad.equals(c.getActividad())) {
				String concat = new String();
				concat = c.getNombre() + " " + c.getFecha() + " " + c.getHoraInicio();
				pair = new Pair<>(c.getNombre(), concat);				
				listado.add(pair);
			}
		}
		return listado;
	}

	public Clase buscarClase(String clase) {
		Clase ret = null;
		for(Clase c: clases) {
			if(c.getNombre().equals(clase))
				ret = c;
		}
		return ret;
	}
}

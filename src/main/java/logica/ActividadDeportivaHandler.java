package logica;

import java.util.ArrayList;
import java.util.List;

public class ActividadDeportivaHandler {
	private static ActividadDeportivaHandler instancia = null;
	private List<ActividadDeportiva> actividades = new ArrayList<>();
	
	private ActividadDeportivaHandler() {}
	
	public static ActividadDeportivaHandler getInstancia() {
		if(instancia == null)
			instancia = new ActividadDeportivaHandler();
		return instancia;
	}
	
	public ArrayList<String> obtenerActividadesInstitucion(String institucion) {
		ArrayList<String> listado = new ArrayList<>();
		for(ActividadDeportiva a: actividades) {
			if(institucion.equals(a.getInstitucion()){
				listado.add(a.getNombre());
			}		
		}
		return listado;
	}	
}

package logica;

import java.util.ArrayList;
import java.util.List;

public class InstitucionDeportivaHandler {
	
	//SINGLETON
	private static InstitucionDeportivaHandler instancia = null;
	private List<InstitucionDeportiva>institucionesDeportivas = new ArrayList<>();
	
	private InstitucionDeportivaHandler() {}
	
	public static InstitucionDeportivaHandler getInstancia() {
		if (instancia == null)
			instancia = new InstitucionDeportivaHandler();
		return instancia;
	}
		
	//METODOS
	
	public void agregarInstitucionDeportiva(InstitucionDeportiva institucion) {
		institucionesDeportivas.add(institucion);
	}
	
	public InstitucionDeportiva buscarInstitucionDeportiva(String nombre) {
		InstitucionDeportiva aretornar = null;
		for(InstitucionDeportiva i: institucionesDeportivas) {
			if(i.getNombre().equals(nombre))
				aretornar = i;
		}
		return aretornar;
	}

	public ArrayList<String> obtenerInstituciones() {
		ArrayList<String> instituciones = new ArrayList<>();
		for(InstitucionDeportiva i: institucionesDeportivas) {
			instituciones.add(new String(i.getNombre()));
		}	
		return instituciones;
	}
	
	public ArrayList<InstitucionDeportiva> obtenerInstitucionesObjeto(){
		ArrayList<InstitucionDeportiva> instituciones = new ArrayList<>();
		for(InstitucionDeportiva i: institucionesDeportivas) {
			instituciones.add(i);
		}	
		return instituciones;
		
	}
}

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
	
	public ArrayList<String> obtenerInstituciones(){
		ArrayList<String> aRetornar = new ArrayList<>();
		for(InstitucionDeportiva id : institucionesDeportivas) {
			aRetornar.add(id.getNombre());
		}
		return aRetornar;
	}
}

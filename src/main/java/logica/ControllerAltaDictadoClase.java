package logica;

import java.util.ArrayList;
import javafx.util.Pair;
import datatypes.DtActividadDeportiva;
import datatypes.DtClase;
import excepciones.ClaseRepetidaException;
import excepciones.EsSocioException;
import excepciones.NoExisteUsuarioException;
import excepciones.ProfNoTrabajaInstitucion;
import interfaces.IControllerAltaDictadoClase;

public class ControllerAltaDictadoClase implements IControllerAltaDictadoClase {
	
	public String[] listarActividades(String nombre){
		InstitucionDeportivaHandler idh = InstitucionDeportivaHandler.getInstancia();
		InstitucionDeportiva institucion = idh.buscarInstitucionDeportiva(nombre);
		ArrayList<DtActividadDeportiva> actividades = institucion.obtenerActividades();
		ArrayList<Pair<String,String>> listaActividades = new ArrayList<>();
		
		/*ArrayList<DtActividadDeportiva> actividades = institucion.obtenerActividades();
		return actividades;
		
		ArrayList<DtActividadDeportiva> actividades = insti.obtenerActividades();
		ArrayList<Pair<DtClase,String>> listado = new ArrayList<>();
		for(DtActividadDeportiva a: actividades) {
			if(a.getNombre().equals(actividad)) {
				ActividadDeportiva act = insti.buscarActividad(actividad);
				for(DtClase dtc:act.obtenerClases()) {
					String concat = new String();
					concat = dtc.getNombre() + " " + dtc.getFecha() + " " + dtc.getHoraInicio();
					Pair<DtClase, String> pair = new Pair<>(dtc, concat);
					listado.add(pair);
				}	
			}
		}
		String[] repo = new String[listado.size()];
		int u=0;
		for(Pair<DtClase,String> dtc:listado) {
			repo[u] = dtc.getValue();
			u++;
		}
		return repo;
		*/
	}

	public void altaClase(DtClase clase) throws ClaseRepetidaException, NoExisteUsuarioException, EsSocioException, ProfNoTrabajaInstitucion {
		InstitucionDeportivaHandler idh = InstitucionDeportivaHandler.getInstancia();
		InstitucionDeportiva institucion = idh.buscarInstitucionDeportiva(clase.getNomInstitucion()); //instancio institucion deportiva
		
		ActividadDeportiva actividad = institucion.buscarActividad(clase.getNomActividad()); //instancio actividad deportiva
		
		Clase nuevaClase = actividad.buscarClase(clase.getNombre()); //busco si ya existe una clase con ese nombre
		if(nuevaClase != null)
			throw new ClaseRepetidaException("Ya existe una clase con nombre '" + clase.getNombre() + "'");
		
		UsuarioHandler usuarios = UsuarioHandler.getInstancia();
		Usuario usuario = usuarios.buscarUsuarioNick(clase.getNickProfesor()); //busco instancia del usuario - profesor
		
		if(usuario == null)
			throw new NoExisteUsuarioException("El usuario seleccionado no existe."); 
		if(usuario instanceof Socio)
			throw new EsSocioException("El usuario '" + usuario.getNickname() +"' es un Socio.");
		Profesor prof = (Profesor) usuario; //instancia Profesor
		
		if(!prof.getInstitucion().equals(institucion)) //verifico que el profesor trabaja en la institucion seleccionada
			throw new ProfNoTrabajaInstitucion("El profesor '" + clase.getNickProfesor() + "' no trabaja en la instituci�n '" + institucion.getNombre() + "'");
		
		nuevaClase = new Clase(clase.getNombre(), clase.getFecha(), clase.getHoraInicio(), clase.getUrl(), clase.getFechaReg()); //creo la nueva clase
		
		actividad.agregarClase(nuevaClase); //agrego la nueva clase de la actividad deportiva a la lista
		
		prof.agregarClase(nuevaClase); //agrego la nueva clase a la lista de clases dictadas del profesor
	}
}

package logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.persistence.EntityManager;

import datatypes.DtActividadDeportiva;
import datatypes.DtClase;
import excepciones.ClaseRepetidaException;
import excepciones.EsSocioException;
import excepciones.NoExisteUsuarioException;	
import excepciones.ProfNoTrabajaInstitucion;
import interfaces.IControllerAltaDictadoClase;
import persistencia.Conexion;

public class ControllerAltaDictadoClase implements IControllerAltaDictadoClase {
	@Override
	public String[] listarActividades(String nomInstitucion){
		InstitucionDeportivaHandler idh = InstitucionDeportivaHandler.getInstancia();
		InstitucionDeportiva institucion = idh.buscarInstitucionDeportiva(nomInstitucion);
		ArrayList<DtActividadDeportiva> actividades = institucion.obtenerActividades();
		ArrayList<Map<DtActividadDeportiva,String>> listaActividades = new ArrayList<>();
		Map<DtActividadDeportiva,String> pair = new HashMap<DtActividadDeportiva,String>();
		for(DtActividadDeportiva dta : actividades) {
			String concat = new String();
			concat = dta.getNombre() + " - " + dta.getDescripcion();
			pair.put(dta, concat);
			listaActividades.add(pair);
		}
		String[] retorno = new String[listaActividades.size()];
		int i = 0;
		Iterator<DtActividadDeportiva> it = pair.keySet().iterator();
		while(it.hasNext()) {
			DtActividadDeportiva key = (DtActividadDeportiva) it.next();
			retorno[i] = pair.get(key);
			i++;
		}
		return retorno;
	}

	public void altaClase(DtClase clase) throws ClaseRepetidaException, NoExisteUsuarioException, EsSocioException, ProfNoTrabajaInstitucion {
		InstitucionDeportivaHandler idh = InstitucionDeportivaHandler.getInstancia();
		InstitucionDeportiva institucion = idh.buscarInstitucionDeportiva(clase.getNomInstitucion()); //instancio institucion deportiva
		
		ActividadDeportiva actividad = buscarActividadSeleccionada(institucion, clase.getActividad()); //instancio actividad deportiva
		
		if(idh.existeClase(clase.getNombre()))
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
		
		Clase nuevaClase = new Clase(clase.getNombre(), clase.getFecha(), clase.getHoraInicio(), clase.getUrl(), clase.getFechaReg(), actividad); //creo la nueva clase
		
		actividad.agregarClase(nuevaClase); //agrego la nueva clase de la actividad deportiva a la lista
		
		prof.agregarClase(nuevaClase); //agrego la nueva clase a la lista de clases dictadas del profesor
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		em.persist(actividad);
		em.getTransaction().commit();
	}
	
	public ActividadDeportiva buscarActividadSeleccionada(InstitucionDeportiva institucion, String actividad) {
		String[] split = actividad.split(" - ");
		String nomActividad = split[0];
		ActividadDeportiva retorno = institucion.buscarActividad(nomActividad);
		return retorno;
	}
}
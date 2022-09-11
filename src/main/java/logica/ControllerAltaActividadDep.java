package logica;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import excepciones.ExisteActividadDepException;
import excepciones.NoExistenInstitucionesException;
import interfaces.IControllerAltaActividadDep;

public class ControllerAltaActividadDep implements IControllerAltaActividadDep {
	
	public void altaActividadDep(String nombre, String nomInstitucion, String descripcion, Float duracion, BigDecimal costo, Date fechaAlta) 
			throws ExisteActividadDepException, NoExistenInstitucionesException{
		InstitucionDeportivaHandler idh = InstitucionDeportivaHandler.getInstancia();
		InstitucionDeportiva institucion = idh.buscarInstitucionDeportiva(nomInstitucion); //instancio institucion
		ArrayList<String> existenInstituciones = idh.obtenerInstituciones();
		if(existenInstituciones.isEmpty())
			throw new NoExistenInstitucionesException("No existen instituciones en el sistema, debe dar de alta al menos una para poder continuar");
		
		ActividadDeportiva actividad = institucion.buscarActividad(nomInstitucion); //busco si existe una actividad con ese nombre en la institucion
		if(actividad != null)
			throw new ExisteActividadDepException("Ya existe la actividad '" + nombre + "' en la institución '" + nomInstitucion +"'");
		
		actividad = new ActividadDeportiva(nombre, descripcion, duracion, costo, fechaAlta); //se crea la actividad deportiva
		
		institucion.agregarActividad(actividad); //agrego la actividad a la lista de actividades de la institucion
		
	}
}

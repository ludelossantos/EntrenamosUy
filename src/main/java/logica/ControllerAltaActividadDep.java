package logica;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.EntityManager;

import datatypes.DtProfesor;
import excepciones.ExisteActividadDepException;
import excepciones.NoExistenInstitucionesException;
import interfaces.IControllerAltaActividadDep;
import persistencia.Conexion;

public class ControllerAltaActividadDep implements IControllerAltaActividadDep {
	
	public void altaActividadDep(String nombre, String nomInstitucion, String descripcion, Float duracion, BigDecimal costo, Date fechaAlta) 
			throws ExisteActividadDepException, NoExistenInstitucionesException{
		InstitucionDeportivaHandler idh = InstitucionDeportivaHandler.getInstancia();
		InstitucionDeportiva institucion = idh.buscarInstitucionDeportiva(nomInstitucion); //instancio institucion
		ArrayList<String> existenInstituciones = idh.obtenerInstituciones();
		if(existenInstituciones.isEmpty())
			throw new NoExistenInstitucionesException("No existen instituciones en el sistema, debe dar de alta al menos una para poder continuar");
		if(idh.existeActividadDep(nombre))
			throw new ExisteActividadDepException("Ya existe la actividad '" + nombre + "' en la instituci\u00F3n '" + nomInstitucion +"'");
		
		ActividadDeportiva actividad = new ActividadDeportiva(nombre, descripcion, duracion, costo, fechaAlta, institucion); //se crea la actividad deportiva
		
		institucion.agregarActividadDeportiva(actividad); //agrego la actividad a la lista de actividades de la institucion
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		em.persist(institucion);
		em.getTransaction().commit();
	}
}
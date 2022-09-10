package logica;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.EntityManager;

import persistencia.Conexion;

public class InstitucionDeportivaHandler {

	
	//SINGLETON
	private static InstitucionDeportivaHandler instancia = null;
	//private List<InstitucionDeportiva>institucionesDeportivas = new ArrayList<>();
	
	private InstitucionDeportivaHandler() {}
	
	public static InstitucionDeportivaHandler getInstancia() {
		if (instancia == null)
			instancia = new InstitucionDeportivaHandler();
		return instancia;
	}
		
	//METODOS
	
	public void agregarInstitucionDeportiva(InstitucionDeportiva institucion) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		//InstitucionDeportiva instiDepor = new InstitucionDeportiva("Goes","Un gym", "www.goes.com.uy");
		
		em.getTransaction().begin();
		em.persist(institucion);		
		em.getTransaction().commit();
		
		//institucionesDeportivas.add(institucion);
	}
	
	public InstitucionDeportiva buscarInstitucionDeportiva(String nombre) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager eManager = conexion.getEntityManager();
		
		InstitucionDeportiva institucion = eManager.find(InstitucionDeportiva.class, nombre);
		return institucion;
	}
	
	/*
	public InstitucionDeportiva buscarInstitucionDeportiva(String nombre) {
		InstitucionDeportiva aretornar = null;
		for(InstitucionDeportiva i: institucionesDeportivas) {
			if(i.getNombre().equals(nombre))
				aretornar = i;
		}
		return aretornar;
	}*/
	
	public InstitucionDeportiva obtenerInstitucionDeportiva(String nombre){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		InstitucionDeportiva insti = em.find(InstitucionDeportiva.class, nombre);
		return insti;
	}
	
}

package logica;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import persistencia.Conexion;

public class InstitucionDeportivaHandler {
	//SINGLETON
	private static InstitucionDeportivaHandler instancia = null;

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
		em.getTransaction().begin();
		em.persist(institucion);
		em.getTransaction().commit();
	}
	
	public InstitucionDeportiva buscarInstitucionDeportiva(String nombre) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		InstitucionDeportiva aretornar = em.find(InstitucionDeportiva.class, nombre);
		return aretornar;
	}

	public ArrayList<String> obtenerInstituciones() {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		javax.persistence.Query query = em.createQuery("select i from InstitucionDeportiva i");
		List<InstitucionDeportiva> institucionesDeportivas = (List<InstitucionDeportiva>) query.getResultList();
		ArrayList<String> instituciones = new ArrayList<>();
		for(InstitucionDeportiva i: institucionesDeportivas) {
			instituciones.add(new String(i.getNombre()));
		}
		return instituciones;
	}
	
	public ArrayList<InstitucionDeportiva> obtenerInstitucionesObjeto(){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		javax.persistence.Query query = em.createQuery("select i from InstitucionDeportiva i");
		List<InstitucionDeportiva> institucionesDeportivas = (List<InstitucionDeportiva>) query.getResultList();
		ArrayList<InstitucionDeportiva> instituciones = new ArrayList<>();
		for(InstitucionDeportiva i: institucionesDeportivas) {
			instituciones.add(i);
		}	
		return instituciones;
	}
	
	public InstitucionDeportiva obtenerInstitucionDeportiva(String nombre){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		InstitucionDeportiva insti = em.find(InstitucionDeportiva.class, nombre);
		return insti;
	}
}

package logica;

import java.util.ArrayList;

import javax.persistence.EntityManager;

import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;
import excepciones.EmailRepetidoException;
import excepciones.NicknameRepetidoException;
import interfaces.IControllerAltaUsuario;
import persistencia.Conexion;

public class ControllerAltaUsuario implements IControllerAltaUsuario {

	public ControllerAltaUsuario(){
		super();
	}

	@Override
	public void altaUsuario(DtUsuario nuevo) throws NicknameRepetidoException, EmailRepetidoException{
		UsuarioHandler usuarios = UsuarioHandler.getInstancia();
		Usuario usuario = usuarios.buscarUsuarioNick(nuevo.getNickname());
		if(usuario != null) {
			throw new NicknameRepetidoException("El nickname '" + nuevo.getNickname() + "' ya est\u00E1 en uso.");
		}
		usuario = usuarios.buscarUsuarioEmail(nuevo.getEmail());
		if(usuario != null) {
			throw new EmailRepetidoException("El email '" + nuevo.getEmail() + "' ya est\u00E1 en uso.");
		}
		if(nuevo instanceof DtProfesor) {
			InstitucionDeportiva institucion = ((DtProfesor) nuevo).getInstitucion();
			Profesor profe = new Profesor(nuevo.getNickname(), nuevo.getNombre(), nuevo.getApellido(), nuevo.getEmail(), nuevo.getFechaNac(), 
					((DtProfesor) nuevo).getDescripcion(), ((DtProfesor) nuevo).getBiografia(), ((DtProfesor) nuevo).getSitioWeb(), institucion);
			usuarios.agregarUsuario(profe);
			institucion.agregarProfesor(profe);
			Conexion conexion = Conexion.getInstancia();
			EntityManager em = conexion.getEntityManager();
			em.getTransaction().begin();
			em.persist(institucion);
			em.getTransaction().commit();
		}
		if(nuevo instanceof DtSocio) {
			Socio socio = new Socio(nuevo.getNickname(), nuevo.getNombre(), nuevo.getApellido(), nuevo.getEmail(), nuevo.getFechaNac());
			usuarios.agregarUsuario(socio);
		}
	} 
	
	@Override 
	public String[] listarInstituciones() {
		InstitucionDeportivaHandler instHand = InstitucionDeportivaHandler.getInstancia();
		ArrayList<String> instituciones = instHand.obtenerInstituciones();
		String[] instiList = new String[instituciones.size()];
		int i=0;
		for(String n:instituciones) {
			instiList[i]=n;
			i++;
		}
		return instiList;
	}

	@Override //PARA PRUEBAS BORRAR
	public InstitucionDeportiva buscarInstitucion(String insti) {
		InstitucionDeportivaHandler instiHand = InstitucionDeportivaHandler.getInstancia();
		InstitucionDeportiva institucion = instiHand.buscarInstitucionDeportiva(insti);
		return institucion;
	}
}



package logica;

import java.util.ArrayList;
import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;
import excepciones.EmailRepetidoException;
import excepciones.NicknameRepetidoException;
import interfaces.IControllerAltaUsuario;

public class ControllerAltaUsuario implements IControllerAltaUsuario {

	public ControllerAltaUsuario(){
		super();
	}

	@Override
	public void altaUsuario(DtUsuario nuevo) throws NicknameRepetidoException, EmailRepetidoException{
		UsuarioHandler usuarios = UsuarioHandler.getInstancia();
		Usuario usuario = usuarios.buscarUsuarioNick(nuevo.getNickname());
		if(usuario != null) {
			throw new NicknameRepetidoException("El nickname '" + nuevo.getNickname() + "' ya está en uso.");
		}
		usuario = usuarios.buscarUsuarioEmail(nuevo.getEmail());
		if(usuario != null) {
			throw new EmailRepetidoException("El email '" + nuevo.getEmail() + "' ya está en uso.");
		}
		if(nuevo instanceof DtProfesor)
			usuario = new Profesor(nuevo.getNickname(), nuevo.getNombre(), nuevo.getApellido(), nuevo.getEmail(), nuevo.getFechaNac(), ((DtProfesor) nuevo).getDescripcion(), ((DtProfesor) nuevo).getBiografia(), ((DtProfesor) nuevo).getSitioWeb(), ((DtProfesor) nuevo).getInstitucion());
		if(nuevo instanceof DtSocio)
			usuario = new Socio(nuevo.getNickname(), nuevo.getNombre(), nuevo.getApellido(), nuevo.getEmail(), nuevo.getFechaNac());
		usuarios.agregarUsuario(usuario);
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



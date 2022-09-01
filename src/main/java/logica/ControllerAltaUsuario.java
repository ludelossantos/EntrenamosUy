package logica;

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
			throw new NicknameRepetidoException("El nickname " + nuevo.getNickname() + "ya está en uso.");
		}
		usuario = usuarios.buscarUsuarioEmail(nuevo.getEmail());
		if(usuario != null) {
			throw new EmailRepetidoException("El email " + nuevo.getEmail() + "ya está en uso.");
		}
		if(nuevo instanceof DtProfesor)
			usuario = new Profesor(nuevo.getNickname(), nuevo.getNombre(), nuevo.getApellido(), nuevo.getEmail(), nuevo.getFechaNac(), ((DtProfesor) nuevo).getDescripcion(), ((DtProfesor) nuevo).getBiografia(), ((DtProfesor) nuevo).getSitioWeb());
		if(nuevo instanceof DtSocio)
			usuario = new Socio(nuevo.getNickname(), nuevo.getNombre(), nuevo.getApellido(), nuevo.getEmail(), nuevo.getFechaNac());
		usuarios.agregarUsuario(usuario);
	} 
}

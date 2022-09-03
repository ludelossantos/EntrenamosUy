package logica;

import java.util.Date;

import javax.swing.JOptionPane;

import datatypes.DtSocio;
import excepciones.RegistroClaseRepetidoException;
import interfaces.IControllerRegistroClase;

public class ControllerRegistroClase implements IControllerRegistroClase {
	
	public ControllerRegistroClase() {
		super();
	}
	
	@Override
	public void registroClase(String clase, DtSocio socio, Date fecha) throws RegistroClaseRepetidoException{
		UsuarioHandler usuarios = UsuarioHandler.getInstancia();
		Usuario usuario = usuarios.buscarUsuarioNick(socio.getNickname());
		ClaseHandler clases = ClaseHander.getInstancia();
		Clase clase = clases.buscarClase(clase);
		if(usuario instanceof DtSocio) {	
			if(usuarioRegClase()) 
				throw new RegistroClaseRepetidoException("El socio "+ usuReg.getNickname() + " ya se ha registrado a esta clase");
			socio.registrarClase(clase, fecha);
		}	
	}
}

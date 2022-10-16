package logica;

import datatypes.DtUsuario;
import excepciones.UsuarioEnUsoException;
import interfaces.IControllerSesion;

public class ControllerSesion implements IControllerSesion {
	
	public ControllerSesion() {
		super();
	}
	
	@Override
	public int iniciarSesion(String usuario, String pass) throws UsuarioEnUsoException{
		//si devuelve 1 es un socio - 2 es un profesor - 0 error
		int res=0;
		UsuarioHandler usuHand = UsuarioHandler.getInstancia();
		if(usuHand.existeUsuarioPass(usuario, pass)) {
			String tipo = usuHand.tipoUsuario(usuario);
			if(tipo != null && tipo.equals("S")) {
				res= 1;
				System.out.println("resultado socio");
			}else if(tipo != null && tipo.equals("P")) {
				res= 2;
				System.out.println("resultado profesor");
			}
		} else {
			throw new UsuarioEnUsoException("Credenciales incorrectas.");
		}
		return res;
	}
	
	@Override
	public DtUsuario obtenerDtUsuario(String usuario) {
		UsuarioHandler usuHand = UsuarioHandler.getInstancia();
		Usuario usu = usuHand.buscarUsuarioNick(usuario);
		if(usu == null) {
			usu = usuHand.buscarUsuarioEmail(usuario);
		}
		return usu.getDtUsuarioFoto();
	}
}

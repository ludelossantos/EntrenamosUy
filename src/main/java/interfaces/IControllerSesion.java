package interfaces;

import datatypes.DtUsuario;
import excepciones.UsuarioEnUsoException;

public interface IControllerSesion {
	//si devuelve 1 es un socio - 2 es un profesor - 0 error
	public int iniciarSesion(String usuario, String pass) throws UsuarioEnUsoException;
	public DtUsuario obtenerDtUsuario(String usuario);
}

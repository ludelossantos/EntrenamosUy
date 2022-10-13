package interfaces;

import datatypes.DtUsuario;
import excepciones.EmailRepetidoException;
import excepciones.NicknameRepetidoException;

public interface IControllerAltaUsuario {
	public void altaUsuario(DtUsuario usuario) throws NicknameRepetidoException, EmailRepetidoException;
}

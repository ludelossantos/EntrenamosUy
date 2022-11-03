package interfaces;

import datatypes.DtProfesor;
import datatypes.DtUsuario;
import excepciones.NoExisteUsuarioException;

public interface IControllerModificarUsuario {
    public DtUsuario obtenerDtUsuario(String usuario) throws NoExisteUsuarioException;
    public void modificarUsuario(DtUsuario nuevo);
    public String tipoUsuario(String usuario);
    public DtProfesor obtenerDtProfesor(String nickname);
}

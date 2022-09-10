package interfaces;

//import java.util.ArrayList;

import datatypes.DtUsuario;

public interface IControllerConsultaUsuario {
	public String[] listarUsuarios();
	public DtUsuario DatosUsuario(String nickname);
	public String[] listarClases(String nickname);
	public String[] listarActividades(String nickname);

}

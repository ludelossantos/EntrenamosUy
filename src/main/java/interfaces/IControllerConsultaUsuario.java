package interfaces;

import datatypes.DtActividadDeportiva;
import datatypes.DtClase;

//import java.util.ArrayList;

import datatypes.DtUsuario;

public interface IControllerConsultaUsuario {
	public String[] listarUsuarios();
	public DtUsuario DatosUsuario(String nickname);
	public String[] listarClases(String nickname);
	public String[] listarActividades(String nickname);
	public String obtenerInstitucion(String nickname);
	public DtClase DatosClase(String nickname, String nombreActiv);
	public DtActividadDeportiva DatosActiv(String nickname, String nombreActiv);

}

package interfaces;

import java.util.ArrayList;

import datatypes.DtUsuario;

public interface IControllerConsultaUsuario {
	public String[] listarUsuarios();
	public ArrayList<DtUsuario> listarDatosUsuarios();

}

package interfaces;

import datatypes.DtClase;

public interface IControllerConsultaClase {

	public String[] listarActividades(String nickname);

	public String[] listarClases(String nickname, String nomActividad);
	
	public DtClase obtenerDatosClase(String nickname, String nomActividad, String nomClase);
}

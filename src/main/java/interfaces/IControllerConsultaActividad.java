package interfaces;

import datatypes.DtActividadDeportiva;

public interface IControllerConsultaActividad {

	public String[] listarInstituciones();

	public String[] listarActividades(String nombreInstitucion);
	
	public DtActividadDeportiva obtenerDatosActividad(String nombreInstitucion, String nombreActividad);
}

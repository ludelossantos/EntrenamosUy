package interfaces;

import datatypes.DtActividadDeportiva;

public interface IControllerConsultaActividad {

		String[] listarInstituciones();

		String[] listarActividades(String nombreInstitucion);
		
		DtActividadDeportiva obtenerDatosActividad(String nombreInstitucion, String nombreActividad);

}

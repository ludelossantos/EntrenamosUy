package logica;

import datatypes.DtActividadDeportiva;
import interfaces.IControllerConsultaActividad;

public class ControllerConsultaActividad implements IControllerConsultaActividad {
	
	@Override
	public String[] listarInstituciones() {
	  return InstitucionDeportivaHandler.getInstancia().obtenerInstitucionesObjeto().stream()
			  	.map(i -> i.getNombre())
	    		.toArray(String[]::new);
	}

	@Override
	public String[] listarActividades(String nombreInstitucion) {
		return InstitucionDeportivaHandler.getInstancia().buscarInstitucionDeportiva(nombreInstitucion)
		.obtenerActividadesObjeto().stream().map(i -> i.getNombre()).toArray(String[]::new);
	}

	@Override
	public DtActividadDeportiva obtenerDatosActividad(String nombreInstitucion, String nombreActividad) {
		return InstitucionDeportivaHandler.getInstancia().buscarInstitucionDeportiva(nombreInstitucion).buscarActividad(nombreActividad).getDtActividadDeportiva();
	}
	
	

}

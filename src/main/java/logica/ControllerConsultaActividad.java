package logica;

import java.util.ArrayList;

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
		
		InstitucionDeportivaHandler instiHand = InstitucionDeportivaHandler.getInstancia();
		InstitucionDeportiva insti = instiHand.buscarInstitucionDeportiva(nombreInstitucion);
		ArrayList<DtActividadDeportiva> actividades = insti.obtenerActividades();
		String[] listado = new String[actividades.size()];
		int i=0;
		for(DtActividadDeportiva a:actividades) {
			listado[i] = a.getNombre();
			i++;
		}
		return listado;		/*
		return InstitucionDeportivaHandler.getInstancia().buscarInstitucionDeportiva(nombreInstitucion)
		.obtenerActividadesObjeto().stream().map(i -> i.getNombre()).toArray(String[]::new);*/
	}

	@Override
	public DtActividadDeportiva obtenerDatosActividad(String nombreInstitucion, String nombreActividad) {
		return InstitucionDeportivaHandler.getInstancia().buscarInstitucionDeportiva(nombreInstitucion).buscarActividad(nombreActividad).getDtActividadDeportivaMaxi();
	}
	
	

}

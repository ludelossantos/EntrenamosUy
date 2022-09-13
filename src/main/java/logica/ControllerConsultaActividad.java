package logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
		/*return InstitucionDeportivaHandler.getInstancia().buscarInstitucionDeportiva(nombreInstitucion)
		.obtenerActividadesObjeto().stream().map(i -> i.getNombre()).toArray(String[]::new);	*/
		InstitucionDeportivaHandler idh = InstitucionDeportivaHandler.getInstancia();
		InstitucionDeportiva institucion = idh.buscarInstitucionDeportiva(nombreInstitucion);
		ArrayList<DtActividadDeportiva> actividades = institucion.obtenerActividades();
		ArrayList<Map<DtActividadDeportiva,String>> listaActividades = new ArrayList<>();
		Map<DtActividadDeportiva,String> pair = new HashMap<DtActividadDeportiva,String>();
		for(DtActividadDeportiva dta : actividades) {
			String concat = new String();
			concat = dta.getNombre() + " - " + dta.getDescripcion();
			pair.put(dta, concat);
			listaActividades.add(pair);
		}
		String[] retorno = new String[listaActividades.size()];
		int i = 0;
		Iterator<DtActividadDeportiva> it = pair.keySet().iterator();
		while(it.hasNext()) {
			DtActividadDeportiva key = (DtActividadDeportiva) it.next();
			retorno[i] = pair.get(key);
			i++;
		}
		return retorno;
	}

	@Override
	public DtActividadDeportiva obtenerDatosActividad(String nombreInstitucion, String nombreActividad) {
		InstitucionDeportiva institucion = InstitucionDeportivaHandler.getInstancia().buscarInstitucionDeportiva(nombreInstitucion);
		ActividadDeportiva actividad = institucion.buscarActividadSeleccionada(nombreActividad);
		DtActividadDeportiva dta = actividad.getDtActividadDeportivaMaxi();
		return dta;
		//return InstitucionDeportivaHandler.getInstancia().buscarInstitucionDeportiva(nombreInstitucion).buscarActividad(nombreActividad).getDtActividadDeportivaMaxi();
	}
	/*
	public DtActividadDeportiva obtenerDatosActividadConsUser(String nombreInstitucion, String nombreActividad, String nickname) {
		InstitucionDeportiva institucion = InstitucionDeportivaHandler.getInstancia().buscarInstitucionDeportiva(nombreInstitucion);
		ActividadDeportiva actividad = institucion.buscarActividadSeleccionada(nombreActividad);
		DtActividadDeportiva dta = actividad.getDtActividadDeportivaMaxi2(nickname);
		return dta;
		//return InstitucionDeportivaHandler.getInstancia().buscarInstitucionDeportiva(nombreInstitucion).buscarActividad(nombreActividad).getDtActividadDeportivaMaxi();
	}*/
	
	public ActividadDeportiva buscarActividadSeleccionada(InstitucionDeportiva institucion, String actividad) {
		String[] split = actividad.split(" - ");
		String nomActividad = split[0];
		ActividadDeportiva retorno = institucion.buscarActividad(nomActividad);
		return retorno;
	}
}

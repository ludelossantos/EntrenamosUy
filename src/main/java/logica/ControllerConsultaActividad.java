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
		.obtenerActividadesObjeto().stream().map(i -> i.getNombre()).toArray(String[]::new);*/
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
		return InstitucionDeportivaHandler.getInstancia().buscarInstitucionDeportiva(nombreInstitucion).buscarActividad(nombreActividad).getDtActividadDeportivaMaxi();
	}
}

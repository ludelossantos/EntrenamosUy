package logica;

import java.util.ArrayList;

import datatypes.DtInstitucionDeportiva;
import excepciones.InstitucionDeportivaRepetidaException;
import interfaces.IControllerInstitucionDeportiva;

public class ControllerInstitucionDeportiva implements IControllerInstitucionDeportiva {

	// CONTRUCTOR
	
	public ControllerInstitucionDeportiva() {
		super();
	}
	
	// METODOS
 
	public void altaInstitucion(DtInstitucionDeportiva instDepor) throws InstitucionDeportivaRepetidaException {
		InstitucionDeportivaHandler idh = InstitucionDeportivaHandler.getInstancia();

		InstitucionDeportiva institucion = idh.buscarInstitucionDeportiva(instDepor.getNombre());
		if(institucion != null)
			throw new InstitucionDeportivaRepetidaException("Ya existe registrada una Institución Deportiva con el nombre: " + instDepor.getNombre());

		institucion = new InstitucionDeportiva(instDepor.getNombre(), instDepor.getDescripcion(), instDepor.getUrl());
		idh.agregarInstitucionDeportiva(institucion);
	}

	@Override
	public String[] obtenerInstituciones() {
		ArrayList<String> instituciones;
		InstitucionDeportivaHandler idh = InstitucionDeportivaHandler.getInstancia();
		instituciones = idh.obtenerInstituciones();
		String[] aRetornar = new String[instituciones.size()];
        int i=0;
        for(String inst : instituciones) {
        	aRetornar[i] = inst;
        	i++;
        }
        return aRetornar;
	}
}

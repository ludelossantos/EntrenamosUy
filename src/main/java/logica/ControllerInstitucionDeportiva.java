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
	
	// METODOS INSTITUCIONES

	@Override
	public void altaInstitucion(DtInstitucionDeportiva instDepor) throws InstitucionDeportivaRepetidaException {
		InstitucionDeportivaHandler idh = InstitucionDeportivaHandler.getInstancia();
		
		InstitucionDeportiva institucion = idh.obtenerInstitucionDeportiva(instDepor.getNombre());
		if(institucion != null)
			throw new InstitucionDeportivaRepetidaException("Ya existe registrada una Instituci\u00F3n Deportiva con el nombre: " + instDepor.getNombre());
		
		institucion = new InstitucionDeportiva(instDepor.getNombre(), instDepor.getDescripcion(), instDepor.getUrl());
		idh.agregarInstitucionDeportiva(institucion);
	}

	@Override
	public boolean existeInstitucionDeportiva(String nombre) {
		InstitucionDeportivaHandler iDH = InstitucionDeportivaHandler.getInstancia();
		InstitucionDeportiva institucion = iDH.obtenerInstitucionDeportiva(nombre);
        return institucion != null;
	}

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
	
	@Override
	public InstitucionDeportiva buscarInstitucion(String institucion) {
		InstitucionDeportivaHandler idh = InstitucionDeportivaHandler.getInstancia();
		InstitucionDeportiva insti = idh.buscarInstitucionDeportiva(institucion);
		return insti;
	}
}

package logica;

import java.util.ArrayList;

import interfaces.IControllerInstitucionDeportiva;

public class ControllerInstitucionDeportiva implements IControllerInstitucionDeportiva {

	// CONTRUCTOR
	
	public ControllerInstitucionDeportiva() {
		super();
	}
	
	// METODOS
 
	public Boolean existeInstitucion(String nombre) {
		InstitucionDeportivaHandler idh = InstitucionDeportivaHandler.getInstancia();
		if (idh.buscarInstitucionDeportiva(nombre).equals(null))
			return false;
		else
			return true;
	}

	public void altaInstitucion(String nombre, String descripcion, String url) {
		InstitucionDeportiva institucion = new InstitucionDeportiva();
		InstitucionDeportivaHandler idh = InstitucionDeportivaHandler.getInstancia();
		idh.agregarInstitucionDeportiva(institucion);
	}
//puede que falte excepcion de nombre repetido
	
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

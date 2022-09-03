package logica;

import java.util.ArrayList;

import interfaces.IControllerInstitucionDeportiva;

public class ControllerInstitucionDeportiva implements IControllerInstitucionDeportiva {

	// CONTRUCTOR
	
	public ControllerInstitucionDeportiva() {
		super();
	}
	
	
	// METODOS
 
	@Override
	public Boolean existeInstitucion(String nombre) {
		InstitucionDeportivaHandler idh = InstitucionDeportivaHandler.getInstancia();
		if (idh.buscarInstitucionDeportiva(nombre).equals(null))
			return false;
		else
			return true;
	}

	@Override
	public void altaInstitucion(String nombre, String descripcion, String url) {
		InstitucionDeportiva institucion = new InstitucionDeportiva();
		
		InstitucionDeportivaHandler idh = InstitucionDeportivaHandler.getInstancia();
		idh.agregarInstitucionDeportiva(institucion);
	}
	
	@Override
	public String[] listarInstituciones() {
		ArrayList<String> instituciones;
		InstitucionDeportivaHandler instHand = InstitucionDeportivaHandler.getInstancia();
		instituciones = instHand.obtenerInstituciones();
		String[] instiList = new String[instituciones.size()];
		int i=0;
		for(String n:instituciones) {
			instiList[i]=n;
			i++;
		}
		return instiList;
	}
}

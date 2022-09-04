package logica;

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

}

package interfaces;

import datatypes.DtInstitucionDeportiva;
import excepciones.InstitucionDeportivaRepetidaException;
import logica.InstitucionDeportiva;


public interface IControllerInstitucionDeportiva {
	
	//public Boolean existeInstitucion(String nombre);
	//public void altaInstitucion(String nombre, String descripcion, String url);
	public void altaInstitucion(DtInstitucionDeportiva instDepor) throws InstitucionDeportivaRepetidaException;
	public boolean existeInstitucionDeportiva(String nombre);
	//public void modificarInstitucionDeportiva(InstitucionDeportiva iD, String nombre, String descripcion, String url);
	public String[] obtenerInstituciones();
	
}

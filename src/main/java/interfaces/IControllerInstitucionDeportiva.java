package interfaces;

import datatypes.DtInstitucionDeportiva;
import excepciones.InstitucionDeportivaRepetidaException;


public interface IControllerInstitucionDeportiva {
	public void altaInstitucion(DtInstitucionDeportiva instDepor) throws InstitucionDeportivaRepetidaException;
	public boolean existeInstitucionDeportiva(String nombre);
	//public void modificarInstitucionDeportiva(InstitucionDeportiva iD, String nombre, String descripcion, String url);
}

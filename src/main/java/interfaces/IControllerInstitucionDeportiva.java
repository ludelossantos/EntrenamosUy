package interfaces;

import datatypes.DtInstitucionDeportiva;
import excepciones.InstitucionDeportivaRepetidaException;

public interface IControllerInstitucionDeportiva {
	
	public void altaInstitucion(DtInstitucionDeportiva instDepor) throws InstitucionDeportivaRepetidaException;
	
	public String[] obtenerInstituciones();
	
}

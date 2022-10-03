package interfaces;

import datatypes.DtInstitucionDeportiva;
import excepciones.InstitucionDeportivaRepetidaException;
import logica.InstitucionDeportiva;


public interface IControllerInstitucionDeportiva {
	//METODOS INSTITUCIONES
	public void altaInstitucion(DtInstitucionDeportiva instDepor) throws InstitucionDeportivaRepetidaException;
	public boolean existeInstitucionDeportiva(String nombre);
	public String[] obtenerInstituciones();
	public InstitucionDeportiva buscarInstitucion(String institucion);
}

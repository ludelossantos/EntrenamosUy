package interfaces;

import datatypes.DtClase;
import excepciones.EsSocioException;
import excepciones.ClaseRepetidaException;
import excepciones.NoExisteUsuarioException;
import excepciones.ProfNoTrabajaInstitucion;

public interface IControllerAltaDictadoClase {
	//public ArrayList<DtActividadDeportiva> listarActividades(String nombre);
	public String[] listarActividades(String nombre);
	public void altaClase(DtClase clase) throws ClaseRepetidaException, NoExisteUsuarioException, EsSocioException, ProfNoTrabajaInstitucion;
	public void altaClaseWeb(DtClase clase) throws ClaseRepetidaException, NoExisteUsuarioException, EsSocioException, ProfNoTrabajaInstitucion;
}

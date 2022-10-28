package interfaces;

import java.math.BigDecimal;
import java.util.Date;
import excepciones.ExisteActividadDepException;
import excepciones.NoExistenInstitucionesException;

public interface IControllerAltaActividadDep {
	public void altaActividadDep(String nombre, String nomInstitucion, String descripcion, Float duracion, BigDecimal costo, Date fechaAlta, String foto) 
			throws ExisteActividadDepException, NoExistenInstitucionesException;
}

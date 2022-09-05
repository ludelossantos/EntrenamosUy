package interfaces;

import java.util.Date;

import datatypes.DtSocio;
import excepciones.RegistroClaseRepetidoException;

public interface IControllerRegistroClase {
	
	public void registroClase(String clase, DtSocio socio, Date fecha) throws RegistroClaseRepetidoException;
	
	public boolean usuarioRegistradoAClase(String nickname);
	
	public String[] listarActividadesDeportivas(String institucion); 
	
	public String[] listarClasesActividad(String actividad);
	
}

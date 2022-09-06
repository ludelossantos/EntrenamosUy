package interfaces;

import java.util.Date;

import datatypes.DtClase;
import datatypes.DtSocio;
import excepciones.RegistroClaseRepetidoException;
import logica.Socio;
import logica.Clase;


public interface IControllerRegistroClase {
	
	public String[] listarInstituciones();
	
	public String[] listarActividadesDeportivas(String institucion); 
	
	public String[] listarClasesActividad(String institucion, String actividad);
	
	public String[] listarSocios();

	public Socio buscarSocioNombreApellido(String nombApe);

	public Clase buscarClaseSeleccionada(String institucion, String actividad , String datClase);
	
	public boolean usuarioRegistradoAClase(Socio socio, Clase clase);
	
	public void registroClase(String institucion, String actividad, String datClase, String nombApe, Date fechaReg) throws RegistroClaseRepetidoException;
	
}

package interfaces;

import java.util.Date;

import datatypes.DtClase;
import excepciones.RegistroClaseRepetidoException;
import logica.Socio;
import logica.Clase;


public interface IControllerRegistroClase {
	public String[] listarActividadesDeportivas(String institucion); 
	public String[] listarClasesActividad(String institucion, String actividad);
	public DtClase[] listarDtClasesActividad(String institucion, String actividad);
	public String[] listarSocios();
	public Socio buscarSocioNombreApellido(String nombApe);
	public Clase buscarClaseSeleccionada(String institucion, String actividad , String datClase);
    public DtClase buscarDtClaseSeleccionada(String institucion, String actividad , String datClase);
	public boolean usuarioRegistradoAClase(Socio socio, Clase clase);	
	public void registroClase(String institucion, String actividad, String datClase, String nombApe, Date fechaReg) throws RegistroClaseRepetidoException;
	//nuevas para web... se deberia unificar para ambos
	public Socio buscarSocio(String nickname);
    public Clase buscarClase(String institucion, String actividad, String clase);
	public void registroClaseWeb(String institucion, String actividad, String clase, String nickname, Date fechaReg) throws RegistroClaseRepetidoException;
}

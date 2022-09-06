package interfaces;

import datatypes.DtUsuario;
import excepciones.EmailRepetidoException;
import excepciones.NicknameRepetidoException;
import logica.InstitucionDeportiva;

public interface IControllerAltaUsuario {
	public void altaUsuario(DtUsuario usuario) throws NicknameRepetidoException, EmailRepetidoException;
	public String[] listarInstituciones();
	public InstitucionDeportiva buscarInstitucion(String insti); 
}

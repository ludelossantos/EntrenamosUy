package logica;

import java.util.ArrayList;

import datatypes.DtUsuario;
import interfaces.IControllerConsultaUsuario;

public class ControllerConsultaUsuario implements IControllerConsultaUsuario{

	@Override
	public ArrayList<DtUsuario> listarDatosUsuarios() {
		UsuarioHandler uH = UsuarioHandler.getInstancia();
		ArrayList<Usuario> usuarios = uH.getUsuarios();
		ArrayList<DtUsuario> dtUsuarios = new ArrayList<>();
		for(Usuario u : usuarios) {
			dtUsuarios.add(u.getDtUsuario());
		}
		return dtUsuarios;
	}

}

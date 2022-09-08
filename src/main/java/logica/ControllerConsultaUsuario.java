package logica;

import java.util.ArrayList;

import datatypes.DtUsuario;
import interfaces.IControllerConsultaUsuario;

public class ControllerConsultaUsuario implements IControllerConsultaUsuario{

/*	@Override
	public ArrayList<DtUsuario> listarDatosUsuarios() {
		UsuarioHandler uH = UsuarioHandler.getInstancia();
		ArrayList<Usuario> usuarios = uH.getUsuarios();
		ArrayList<DtUsuario> dtUsuarios = new ArrayList<>();
		for(Usuario u : usuarios) {
			dtUsuarios.add(u.getDtUsuario());
		}
		return dtUsuarios;
	}*/

	@Override
	public String[] listarUsuarios() {
		UsuarioHandler uH = UsuarioHandler.getInstancia();
		ArrayList<String>  usuarios = uH.obtenerUsuarios();
		String [] user_ret = new String[usuarios.size()];
			int i=0;
			for(String u : usuarios) {
				user_ret[i]=u;
				i++;
			}
		return user_ret;
	}

	@Override
	public DtUsuario DatosUsuario(String nickname) {
		UsuarioHandler uH = UsuarioHandler.getInstancia();
		Usuario user = uH.buscarUsuarioNick(nickname);
		DtUsuario usuario = user.getDtUsuario();
		return usuario;
	}
}

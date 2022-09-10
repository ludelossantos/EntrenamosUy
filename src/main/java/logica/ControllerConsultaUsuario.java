package logica;

import java.util.ArrayList;

import datatypes.DtActividadDeportiva;
import datatypes.DtClase;
import datatypes.DtUsuario;
import interfaces.IControllerConsultaUsuario;

public class ControllerConsultaUsuario implements IControllerConsultaUsuario{


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

	@Override
	public String[] listarClases(String nickname) {
		UsuarioHandler uH = UsuarioHandler.getInstancia();
		Usuario user = uH.buscarUsuarioNick(nickname);
		String [] clases_ret = null;
		if (user instanceof Profesor) {
			Profesor p = (Profesor) user;
			if(!p.obtenerClasesQueDicta().isEmpty()) {
				clases_ret = new String[p.obtenerClasesQueDicta().size()];
				int i=0;
				for(DtClase c : p.obtenerClasesQueDicta()) {
					clases_ret[i]=c.getNombre();
					i++;
				}
			}
		}
		if (user instanceof Socio) {
			Socio s = (Socio) user;
			if(!s.obtenerClases().isEmpty()) {
				clases_ret = new String[s.obtenerClases().size()];
				int i = 0;
				for (DtClase c : s.obtenerClases()) {
					clases_ret[i] = c.getNombre();
					i++;
				}
			}
		}
		return clases_ret;
	}

	@Override
	public String[] listarActividades(String nickname) {
		UsuarioHandler uH = UsuarioHandler.getInstancia();
		String [] activ_ret = null;
		Usuario user = uH.buscarUsuarioNick(nickname);
		if (user instanceof Profesor) {
			Profesor p = (Profesor) user;
			if(!p.getInstitucion().obtenerActividades().isEmpty()) {
				activ_ret = new String[p.getInstitucion().obtenerActividades().size()];
				int i=0;
				for(DtActividadDeportiva a : p.getInstitucion().obtenerActividades()) {
					activ_ret[i]=a.getNombre();
					i++;
				}
			}
		}
		return activ_ret;
	}
}

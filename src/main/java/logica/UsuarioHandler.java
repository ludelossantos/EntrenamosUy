package logica;

import java.util.ArrayList;
import java.util.List;
import datatypes.DtSocio;  

public class UsuarioHandler {
	private static UsuarioHandler instancia = null;
	private List<Usuario> usuarios = new ArrayList<>();
	private UsuarioHandler() {
		super();
	}

	public static UsuarioHandler getInstancia() {
		if(instancia == null)
			instancia = new UsuarioHandler();
		return instancia;
	}

	public Usuario buscarUsuarioNick(String nickname) {
		Usuario usuario = null;
		for(Usuario u: usuarios) {
			if(u.getNickname().equals(nickname))
				usuario = u;
		}
		return usuario;
	}

	public Usuario buscarUsuarioEmail(String email) {
		Usuario usuario = null;
		for(Usuario u: usuarios) {
			if(u.getEmail().equals(email))
				usuario = u;
		}
		return usuario;
	}

	public void agregarUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}

	public ArrayList<String> obtenerUsuarios(){
		ArrayList<String> userList = new ArrayList<>();
		for(Usuario u: usuarios) {
			userList.add(new String(u.getNickname()));
		}
		return userList;
	}
	
	public ArrayList<DtSocio> obtenerSocios(){
		ArrayList<DtSocio> listado = new ArrayList<>();
		for(Usuario u: usuarios) {
			if(u instanceof Socio) {
				Socio socio = (Socio) u;
				listado.add(socio.getDtSocio());
			}
		}			
		return listado;
	}		
}

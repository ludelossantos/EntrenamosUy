package logica;


import java.util.ArrayList;
import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;

import datatypes.DtSocio;
import persistencia.Conexion;  

public class UsuarioHandler {
	private static UsuarioHandler instancia = null;
	//private List<Usuario> usuarios = new ArrayList<>();
	private UsuarioHandler() {
		super();
	}
S
	public static UsuarioHandler getInstancia() {
		if(instancia == null)
			instancia = new UsuarioHandler();
		return instancia;
	}

	public Usuario buscarUsuarioNick(String nickname) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Usuario usuario = em.find(Usuario.class, nickname);
		/*
		Usuario usuario = null;
		for(Usuario u: usuarios) {
			if(u.getNickname().equals(nickname))
				usuario = u;
		}*/
		return usuario;
	}

	public Usuario buscarUsuarioEmail(String email) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		javax.persistence.Query query = em.createQuery("select u from Usuario u");
		List<Usuario> usuarios = (List<Usuario>) query.getResultList();	
		Usuario usuario = null;
		for(Usuario u: usuarios) {
			if(u.getEmail().equals(email))
				usuario = u;
		}
		return usuario;
	}

	public void agregarUsuario(Usuario usuario) {
		//usuarios.add(usuario);
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
	}

	public ArrayList<String> obtenerUsuarios(){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		javax.persistence.Query query = em.createQuery("select u from Usuario u");
		List<Usuario> usuarios = (List<Usuario>) query.getResultList();

		ArrayList<String> userList = new ArrayList<>();
		for(Usuario u: usuarios) {
			userList.add(new String(u.getNickname()));
		}
		return userList;
	}
	
	public ArrayList<DtSocio> obtenerSocios(){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		javax.persistence.Query query = em.createQuery("select u from Usuario u");
		List<Usuario> usuarios = (List<Usuario>) query.getResultList();
		
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

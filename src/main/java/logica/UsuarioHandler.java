package logica;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;
import persistencia.Conexion;  

public class UsuarioHandler {
	//SINGLETON
	private static UsuarioHandler instancia = null;
	
	private UsuarioHandler() {
		super();
	}

	public static UsuarioHandler getInstancia() {
		if(instancia == null)
			instancia = new UsuarioHandler();
		return instancia;
	}
	
	//METODOS
	public Usuario buscarUsuarioNick(String nickname) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Usuario usuario = em.find(Usuario.class, nickname);
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
			userList.add(u.getNickname());
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
	
	public ArrayList<Usuario> getUsuarios(){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		javax.persistence.Query query = em.createQuery("select u from Usuario u");
		List<Usuario> usuarios = (List<Usuario>) query.getResultList();
		ArrayList<Usuario> listUsuario = new ArrayList<>(); 
		for (Usuario user : usuarios) {
			listUsuario.add(user);
		}
		return listUsuario;	
	}

	public boolean existeUsuarioPass(String usuario, String pass) {
        Conexion conexion = Conexion.getInstancia();
        EntityManager em = conexion.getEntityManager();
        javax.persistence.Query query = em.createQuery("select u.nickname from Usuario u WHERE (u.email = :usuario OR u.nickname = :usuario) AND u.pass = :pass");
        query.setParameter("usuario", usuario);
        query.setParameter("pass", pass);
        ArrayList<String> res = (ArrayList<String>) query.getResultList();

        return res != null && res.size() > 0;
    }

	public String tipoUsuario(String usuario) {    			    
        Conexion conexion = Conexion.getInstancia();
        EntityManager em = conexion.getEntityManager();
        javax.persistence.Query query = em.createQuery("select u from Usuario u WHERE u.nickname = :usuario OR u.email = :usuario");
        query.setParameter("usuario", usuario);
        Usuario usu = (Usuario) query.getSingleResult();
//        Usuario usu = em.find(Usuario.class, res.get(0));
        System.out.println("ingresa " + usu.getNickname());	    
		if(usu instanceof Socio) {
		    System.out.println("socio tipousuario");
            return "S";
        }
		return "P";
	}

    public boolean actualizarUsuario(DtUsuario nuevo) {
        Conexion conexion = Conexion.getInstancia();
        EntityManager em = conexion.getEntityManager();
        em.getTransaction().begin();       
        String sql = "";
        if(nuevo instanceof DtProfesor) {
            sql = "UPDATE Usuario SET nombre = :nNom, apellido = :nApe, fechanac = :nFecha, foto = :nFoto, pass = :nPass, biografia = :nBio, descripcion = :nDesc, sitioweb = :nWeb, institucion_nombre = :nInst  WHERE nickname = :usuario"; 
        }else {
            sql = "UPDATE Usuario SET nombre = :nNom, apellido = :nApe, fechanac = :nFecha, foto = :nFoto, pass = :nPass  WHERE nickname = :usuario";
        }
       
        javax.persistence.Query query = em.createQuery(sql);
        if(nuevo instanceof DtProfesor) {  
            DtProfesor dtp = (DtProfesor) nuevo;
            query.setParameter("nBio", dtp.getBiografia());
            query.setParameter("nDesc", dtp.getDescripcion());
            query.setParameter("nWeb", dtp.getSitioWeb());
            query.setParameter("nInst", dtp.getInstitucion());
        }
        query.setParameter("nNom", nuevo.getNombre());
        query.setParameter("nApe", nuevo.getApellido());
        query.setParameter("nFecha", nuevo.getFechaNac());
        query.setParameter("nFoto", nuevo.getFoto());
        query.setParameter("nPass", nuevo.getPass());
        query.setParameter("usuario", nuevo.getNickname());
        
        int res = query.executeUpdate();
        em.getTransaction().commit();
        Usuario usu = em.find(Usuario.class, nuevo.getNickname());
        em.refresh(usu);
        if(res > 0) {
            return true;
        } else {
            return false;
        }
    }
}

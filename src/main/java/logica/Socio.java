package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.OneToMany;

import datatypes.DtClase;
import datatypes.DtSocio;
import persistencia.Conexion;

@Entity
@DiscriminatorValue("S")
public class Socio extends Usuario {
	
	@OneToMany(mappedBy = "socio",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Registro> clasesRegistradas = new ArrayList<>();
	
	//CONSTRUCTORES
	public Socio() {
		super();
	}
	
	public Socio(String nickname, String nombre, String apellido, String email, Date fechaNac, String pass, String foto) {
		super(nickname, nombre, apellido, email, fechaNac, pass, foto);
	}
	
	//GETTERS Y SETTERS
	public DtSocio getDtSocio() {
		return new DtSocio(this.getNickname(), this.getNombre(), this.getApellido(), this.getEmail(), this.getFechaNac());
	}
	
	//METODOS
	public void agregarRegistro(Registro registro) {
		clasesRegistradas.add(registro);
	}
	
	public ArrayList<DtClase> obtenerClases(){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		javax.persistence.Query query = em.createQuery("select r from Registro r");
		List<Registro> clasesRegistradas = (List<Registro>) query.getResultList();
		ArrayList<DtClase> lista = new ArrayList<>();
		for(Registro r: clasesRegistradas) {
		    if(r.getSocio().getNickname().equals(this.getNickname())) {
		        lista.add(r.getClase().getDtClase());
		    }
		}
		return lista;
	}
	
}

package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import datatypes.DtClase;
import datatypes.DtProfesor;
import datatypes.DtUsuario;

public class Profesor extends Usuario {
	private String descripcion;
	private String biografia;
	private String sitioWeb;
	private InstitucionDeportiva institucion;
	private List<Clase> clasesQueDicta = new ArrayList<>();
	
	public Profesor() {
		super();
	}

	public Profesor(String descripcion, String biografia, String sitioWeb) {
		super();
		this.descripcion = descripcion;
		this.biografia = biografia;
		this.sitioWeb = sitioWeb;
	}
	
	public Profesor(String nickname, String nombre, String apellido, String email, Date fechaNac, String descripcion, String biografia, String sitioWeb, InstitucionDeportiva institucion) {
		super(nickname, nombre, apellido, email, fechaNac);
		this.descripcion = descripcion;
		this.biografia = biografia;
		this.sitioWeb = sitioWeb;
		this.institucion = institucion;
	}

	public Profesor(String nickname, String nombre, String apellido, String email, Date fechaNac, String descripcion, String biografia, String sitioWeb) {
		super(nickname, nombre, apellido, email, fechaNac);
		this.descripcion = descripcion;
		this.biografia = biografia;
		this.sitioWeb = sitioWeb;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public String getSitioWeb() {
		return sitioWeb;
	}

	public void setSitioWeb(String sitioWeb) {
		this.sitioWeb = sitioWeb;
	}

	public InstitucionDeportiva getInstitucion() {
		return institucion;
		
	}

	public void setInstitucion(InstitucionDeportiva institucion) {
		this.institucion = institucion;
		
	}

	public List<Clase> getClasesQueDicta() {
			return clasesQueDicta;
	}

	public void setClasesQueDicta(ArrayList<Clase> clasesQueDicta) {
		this.clasesQueDicta = clasesQueDicta;
	}

	public DtUsuario getDtUsuario() {
		return new DtProfesor(this.getNickname(), this.getNombre(), this.getApellido(), this.getEmail(), this.getFechaNac(), this.descripcion, this.biografia, this.sitioWeb);
	}
	
	public ArrayList<DtClase> obtenerClasesQueDicta(){
		ArrayList<DtClase> lista = new ArrayList<>();
		for(Clase a : clasesQueDicta) {
			lista.add(a.getDtClase());
		}
		return lista;
		
	}
	
}

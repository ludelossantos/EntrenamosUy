package datatypes;

import java.util.ArrayList;
import java.util.Date;

import logica.Clase;
import logica.InstitucionDeportiva;

public class DtProfesor extends DtUsuario {
	private String descripcion;
	private String biografia;
	private String sitioWeb;
	InstitucionDeportiva institucion;
	private ArrayList<Clase> clasesQueDicta;
	
	public DtProfesor() {
		super();
	}

	public DtProfesor(String descripcion, String biografia, String sitioWeb) {
		super();
		this.descripcion = descripcion;
		this.biografia = biografia;
		this.sitioWeb = sitioWeb;
	}
	
	public DtProfesor(String nickname, String nombre, String apellido, String email, Date fechaNac, String descripcion, String biografia, String sitioWeb, InstitucionDeportiva institucion) {
		super(nickname, nombre, apellido, email, fechaNac);
		this.descripcion = descripcion;
		this.biografia = biografia;
		this.sitioWeb = sitioWeb;
		this.institucion = institucion;
	}
	
	public DtProfesor(String nickname, String nombre, String apellido, String email, Date fechaNac, String descripcion, String biografia, String sitioWeb) {
		super(nickname, nombre, apellido, email, fechaNac);
		this.descripcion = descripcion;
		this.biografia = biografia;
		this.sitioWeb = sitioWeb;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getBiografia() {
		return biografia;
	}

	public String getSitioWeb() {
		return sitioWeb;
	}
	public InstitucionDeportiva getInstitucion() {
		return institucion;
	}

	public ArrayList<Clase> getClasesQueDicta() {
		return clasesQueDicta;
	}
	
	
}

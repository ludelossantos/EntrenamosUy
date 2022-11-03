package datatypes;

import java.util.ArrayList;
import java.util.Date;

import logica.Clase;

public class DtProfesor extends DtUsuario {
	private String descripcion;
	private String biografia;
	private String sitioWeb;
	private String institucion;
	private ArrayList<Clase> clasesQueDicta;
	
	public DtProfesor() {
		super();
	}

	public DtProfesor(String descripcion, String biografia, String sitioWeb, String institucion) {
		super();
		this.descripcion = descripcion;
		this.biografia = biografia;
		this.sitioWeb = sitioWeb;
		this.institucion = institucion;
	}
	
	public DtProfesor(String nickname, String nombre, String apellido, String email, Date fechaNac, String descripcion, String biografia, String sitioWeb, String institucion) {
		super(nickname, nombre, apellido, email, fechaNac);
		this.descripcion = descripcion;
		this.biografia = biografia;
		this.sitioWeb = sitioWeb;
		this.institucion = institucion;
	}
	
    public DtProfesor(String nickname, String nombre, String apellido, String email, Date fechaNac, String pass, String descripcion, String biografia, String sitioWeb, String institucion) {
        super(nickname, nombre, apellido, email, fechaNac, pass);
        this.descripcion = descripcion;
        this.biografia = biografia;
        this.sitioWeb = sitioWeb;
        this.institucion = institucion;
    }  
    
    public DtProfesor(String nickname, String nombre, String apellido, String email, Date fechaNac, String pass, String foto, String descripcion, String biografia, String sitioWeb, String institucion) {
        super(nickname, nombre, apellido, email, fechaNac, pass, foto);
        this.descripcion = descripcion;
        this.biografia = biografia;
        this.sitioWeb = sitioWeb;
        this.institucion = institucion;
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
	public String getInstitucion() {
		return institucion;
	}

	public ArrayList<Clase> getClasesQueDicta() {
		return clasesQueDicta;
	}
	
	
}

package datatypes;

import java.util.Date;

public class DtUsuario {
	private String nickname;
    private String nombre;
    private String apellido;
    private String email;
    private Date fechaNac;
    private String pass;
    
	public DtUsuario() {
		super();
	}

	public DtUsuario(String nickname, String nombre, String apellido, String email, Date fechaNac) {
		super();
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fechaNac = fechaNac;
	}
	
	public DtUsuario(String nickname, String nombre, String apellido, String email, Date fechaNac, String pass) {
		super();
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fechaNac = fechaNac;
		this.pass = pass;
	}

	public String getNickname() {
		return nickname;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getEmail() {
		return email;
	}

	public Date getFechaNac() {
		return fechaNac;
	}
	
	public String getPass() {
		return pass;
	}
    
    
}

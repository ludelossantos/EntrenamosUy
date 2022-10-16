package logica;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import datatypes.DtUsuario;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Usuario {
	@Id
	private String nickname;
    private String nombre;
    private String apellido;
    private String email;
    private Date fechaNac;
    private String pass;
    private String foto;
    
    //CONSTRUCTORES
	public Usuario() {
		super();
	}
	/*
	public Usuario(String nickname, String nombre, String apellido, String email, Date fechaNac) {
		super();
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fechaNac = fechaNac;
	}*/
	
    public Usuario(String nickname, String nombre, String apellido, String email, Date fechaNac, String pass, String foto) {
        super();
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNac = fechaNac;
        this.pass = pass;
        this.foto = foto;
    }

	//GETTERS Y SETTERS
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public DtUsuario getDtUsuario() {
		return new DtUsuario(this.getNickname(), this.getNombre(), this.getApellido(), this.getEmail(), this.getFechaNac());
	}
	
    public DtUsuario getDtUsuarioFoto() {
        return new DtUsuario(this.getNickname(), this.getNombre(), this.getApellido(), this.getEmail(), this.getFechaNac(), this.getPass(), this.getFoto());
    }
	       
}

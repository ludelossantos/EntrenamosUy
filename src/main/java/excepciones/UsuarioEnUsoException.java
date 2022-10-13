package excepciones;

public class UsuarioEnUsoException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public UsuarioEnUsoException(String message) {
		super(message);
	}
}

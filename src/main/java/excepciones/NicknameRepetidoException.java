package excepciones;

public class NicknameRepetidoException extends Exception {
	private static final long serialVersionUID = 1L;

	public NicknameRepetidoException(String string) {
		super(string);
	}

}
package interfaces;


public interface IControllerInstitucionDeportiva {
	
	public Boolean existeInstitucion(String nombre);
	
	public void altaInstitucion(String nombre, String descripcion, String url);

	public String[] listarInstituciones();	
	
}

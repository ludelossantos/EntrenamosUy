package interfaces;

import logica.ControllerAltaUsuario;
import logica.ControllerInstitucionDeportiva;

public class Factory {
	private static Factory instancia = null;

	private Factory() {}
	
	public static Factory getInstance(){
		if (instancia == null)
			instancia = new Factory();
		return instancia;
	}

	public IControllerAltaUsuario getIControllerAltaUsuario() {
		return new ControllerAltaUsuario();
	}
	
	public IControllerInstitucionDeportiva getIControllerInstitucionDeportiva() {
		return new ControllerInstitucionDeportiva();
	}
	
}

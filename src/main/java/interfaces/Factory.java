package interfaces;

import logica.ControllerAltaUsuario;
import logica.ControllerRegistroClase;
import logica.ControllerInstitucionDeportiva;
import logica.ControllerConsultaUsuario;

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

	public IControllerRegistroClase getIControllerRegistroClase() {
		return new ControllerRegistroClase();
	}
	
	public IControllerInstitucionDeportiva getIControllerInstitucionDeportiva() {
		return new ControllerInstitucionDeportiva();
	}
	
	public IControllerConsultaUsuario getIControllerConsultaUsuario() {
		return new ControllerConsultaUsuario();
	}
}

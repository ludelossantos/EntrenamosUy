package interfaces;

import logica.ControllerAltaActividadDep;
import logica.ControllerAltaDictadoClase;
import logica.ControllerAltaUsuario;
import logica.ControllerRegistroClase;
import logica.ControllerSesion;
import logica.ControllerInstitucionDeportiva;
import logica.ControllerConsultaActividad;
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
	
	public IControllerConsultaActividad getIControllerConsultaActividad() {
		return new ControllerConsultaActividad();
	}
	
	public IControllerAltaActividadDep getIControllerAltaActividadDep() {
		return new ControllerAltaActividadDep();
	}
	
	public IControllerAltaDictadoClase getIControllerAltaDictadoClase() {
		return new ControllerAltaDictadoClase();
	}
	
	public IControllerSesion getIControllerSesion() {
		return new ControllerSesion();
	}
}

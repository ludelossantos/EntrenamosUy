package logica;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import datatypes.DtSocio;
import excepciones.RegistroClaseRepetidoException;
import interfaces.IControllerRegistroClase;

public class ControllerRegistroClase implements IControllerRegistroClase {
	
	public ControllerRegistroClase() {
		super();
	}
	
	@Override
	public void registroClase(String clase, DtSocio socio, Date fecha) throws RegistroClaseRepetidoException{
		UsuarioHandler usuHand = UsuarioHandler.getInstancia();
		Usuario usuario = usuHand.buscarUsuarioNick(socio.getNickname());
		ClaseHandler claseHand = ClaseHandler.getInstancia();
		Clase clase = claseHand.buscarClase(clase);
		if(usuario instanceof DtSocio) {	
			if(usuarioRegistrado(socio.getNickname())) 
				throw new RegistroClaseRepetidoException("El socio "+ usuReg.getNickname() + " ya se ha registrado a esta clase");
			socio.registrarClase(clase, fecha);
		}	
	}
	
	@Override
	public boolean usuarioRegistradoAClase(String nickname){
		
		
		return true;
	}
	
	
	@Override
	public String[] listarActividadesDeportivas(String institucion) {
		ActividadDeportivaHandler actiHand = ActividadDeportivaHandler.getInstancia();
		ArrayList<String> actividades = actiHand.obtenerActividadesInstitucion(institucion);
		String[] listado = new String[actividades.size()];
		int i=0;
		for(String a:actividades) {
			listado[i] = a;
			i++;
		}
		return listado;
	}
	
	@Override
	public String[] listarClasesActividad(String actividad) {
		ClaseHandler claseHand = ClaseHandler.getInstancia();
		ArrayList<Pair<String,String>> clases = claseHand.obtenerClasesActividad(actividad);
		String[] listado = new String[clases.size()];
		int i=0;
		for(String c: clases) {
			listado[i] = c;
			i++;
		}	
		return listado;
	}
}

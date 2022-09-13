package logica;


import java.util.ArrayList;
import java.util.Date;
import datatypes.DtActividadDeportiva;
import datatypes.DtClase;
import datatypes.DtSocio;
import excepciones.RegistroClaseRepetidoException;
import interfaces.IControllerRegistroClase;
import javafx.util.Pair;

public class ControllerRegistroClase implements IControllerRegistroClase {
	
	public ControllerRegistroClase() {
		super();
	}
	
	@Override
	public String[] listarInstituciones() {
		InstitucionDeportivaHandler instHand = InstitucionDeportivaHandler.getInstancia();
		ArrayList<String> instituciones = instHand.obtenerInstituciones();
		String[] instiList = new String[instituciones.size()];
		int i=0;
		for(String n:instituciones) {
			instiList[i]=n;
			i++;
		}
		return instiList;
	}	
	
	@Override
	public String[] listarActividadesDeportivas(String institucion) {
		InstitucionDeportivaHandler instiHand = InstitucionDeportivaHandler.getInstancia();
		InstitucionDeportiva insti = instiHand.buscarInstitucionDeportiva(institucion);
		ArrayList<DtActividadDeportiva> actividades = insti.obtenerActividades();
		String[] listado = new String[actividades.size()];
		int i=0;
		for(DtActividadDeportiva a:actividades) {
			listado[i] = a.getNombre();
			i++;
		}
		return listado;
	}
	
	@Override
	public String[] listarClasesActividad(String institucion, String actividad) {
		InstitucionDeportivaHandler instiHand = InstitucionDeportivaHandler.getInstancia();
		InstitucionDeportiva insti = instiHand.buscarInstitucionDeportiva(institucion);
		ActividadDeportiva acti = insti.buscarActividad(actividad);
		ArrayList<DtClase> clases = acti.obtenerClases();
		ArrayList<String> listado = new ArrayList<>();
		for(DtClase dtc: clases) {
			String concat = new String();
			concat = dtc.getNombre() + "  /  " + dtc.getFecha() + "  /  "  + dtc.getHoraInicio();
			listado.add(concat);
		}
		String[] repo = new String[listado.size()];
		int u=0;
		for(String s:listado) {
			repo[u] = s;
			u++;
		}
		return repo;
	}
	
	
	public String[] listarSocios() {
		UsuarioHandler usuHand = UsuarioHandler.getInstancia();
		ArrayList<DtSocio> socios = usuHand.obtenerSocios();
		String[] ret = new String[socios.size()];
		int i=0;
		for(DtSocio s: socios) {
			String concat = s.getNickname() + " / " + s.getNombre() + " " + s.getApellido();
			
			ret[i] = concat;
			i++;
		}
		return ret;
	}
	
	@Override
	public Socio buscarSocioNombreApellido(String nombApe) {
		String[] arr = nombApe.split(" / ");
		String nickname = arr[0];
		UsuarioHandler usuHand = UsuarioHandler.getInstancia();
		Socio socio = (Socio) usuHand.buscarUsuarioNick(nickname);
		return socio;
	}
	
	public Clase buscarClaseSeleccionada(String institucion, String actividad , String datClase) {
		String[] arr = datClase.split(" / ");
		String nombClase = arr [0];
		Clase ret = null;
		InstitucionDeportivaHandler instiHand = InstitucionDeportivaHandler.getInstancia();
		InstitucionDeportiva insti = instiHand.buscarInstitucionDeportiva(institucion);
		ArrayList<DtActividadDeportiva> actividades = insti.obtenerActividades();
		for(DtActividadDeportiva a: actividades) {
			if(a.getNombre().equals(actividad)) {
				ActividadDeportiva act = insti.buscarActividad(actividad);
				for(Clase c:act.obtenerClasesObjeto()) {
					if(c.getNombre().equals(nombClase)) {
						return ret = c;
					}
				}	
			}
		}
		return ret;
	}
	
	@Override
	public boolean usuarioRegistradoAClase(Socio socio, Clase clase){
		boolean ret = false;
		ArrayList<DtClase> clases = socio.obtenerClases();
		if(!clases.isEmpty()) {
			for(DtClase c: clases) {
				if(c.getNombre().equals(clase.getNombre()))
					ret = true;
			}
		}		
		return ret;
	}
	

	@Override
	public void registroClase(String institucion, String actividad, String datClase, String nombApe, Date fechaReg) throws RegistroClaseRepetidoException {
		Socio socio = this.buscarSocioNombreApellido(nombApe);
		Clase clase = this.buscarClaseSeleccionada(institucion, actividad, datClase);
		if(this.usuarioRegistradoAClase(socio, clase)) {
			throw new RegistroClaseRepetidoException("El socio '" + socio.getNombre() + " " + socio.getApellido() + "' ya está registrado en esta clase.");
		}
		Registro registro = new Registro(socio, clase, fechaReg);
		socio.agregarRegistro(registro);
		clase.agregarRegistro(registro);	
	}
}

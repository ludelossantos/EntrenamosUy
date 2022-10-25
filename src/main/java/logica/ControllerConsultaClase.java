package logica;

import datatypes.DtActividadDeportiva;
import datatypes.DtClase;
import interfaces.IControllerConsultaClase;

public class ControllerConsultaClase implements IControllerConsultaClase{
	
        @Override
	public String[] listarActividades(String nickname) {
		UsuarioHandler uH = UsuarioHandler.getInstancia();
		String [] actividades = null;
		Usuario user = uH.buscarUsuarioNick(nickname);
		if (user instanceof Profesor) {
			Profesor p = (Profesor) user;
			if(!p.getInstitucion().obtenerActividadesProfesor(p.getNickname()).isEmpty()) {
				actividades = new String[p.getInstitucion().obtenerActividadesProfesor(p.getNickname()).size()];
				int i=0;
				for(DtActividadDeportiva a : p.getInstitucion().obtenerActividadesProfesor(p.getNickname())) {
					actividades[i]=a.getNombre();
					i++;
				}
			}
		}
		return actividades;
	}

        @Override
	public String[] listarClases(String nickname, String nomActividad) {
		UsuarioHandler uH = UsuarioHandler.getInstancia();
		Usuario user = uH.buscarUsuarioNick(nickname);
		String[] clases = null;
		if(user instanceof Profesor) {
			Profesor p = (Profesor) user;
			if(!p.obtenerClasesActividad(nomActividad).isEmpty()) {
				clases = new String[p.obtenerClasesActividad(nomActividad).size()];
				int i=0;
				for(DtClase c : p.obtenerClasesActividad(nomActividad)) {
					clases[i] = c.getNombre();
					i++;
				}
			}
		}
		return clases;
	}
	
        @Override
	public DtClase obtenerDatosClase(String nickname, String nomActividad, String nomClase) {
		UsuarioHandler uH = UsuarioHandler.getInstancia();
		Usuario user = uH.buscarUsuarioNick(nickname); //busco el usuario logeado
		Profesor profe = (Profesor) user; //casteo a profesor ya que este metodo se ejecuta solo para profesores
		InstitucionDeportiva instiProf = profe.getInstitucion(); //busco institucion donde trabaja el profesor
		ActividadDeportiva actividad = instiProf.buscarActividad(nomActividad); //busco la actividad seleccionada
		System.out.println(nomClase+"en controller");
		Clase clase = actividad.buscarClase(nomClase); //busco la clase seleccionada
		System.out.println("en servidor "+clase.getNombre());
		DtClase clase_ret = clase.getDtClase(); //crea un dtclase con los datos para retornar
		System.out.println("en controller dtclase "+clase_ret.getNombre());
		return clase_ret;
	}
}

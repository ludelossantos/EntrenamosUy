package logica;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.EntityManager;

import datatypes.DtActividadDeportiva;
import datatypes.DtClase;
import datatypes.DtSocio;
import excepciones.RegistroClaseRepetidoException;
import interfaces.IControllerRegistroClase;
import persistencia.Conexion;

public class ControllerRegistroClase implements IControllerRegistroClase {
	
	public ControllerRegistroClase() {
		super();
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
			String pattern = "MM-dd-yyyy";
			String patternHora = "HH:mm";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			SimpleDateFormat simpleDateFormatHora = new SimpleDateFormat(patternHora);
			String fecha = simpleDateFormat.format(dtc.getFecha());
			String hora = simpleDateFormatHora.format(dtc.getHoraInicio());
	
			String concat = new String();
			concat = dtc.getNombre() + "  /  " + fecha + "  /  "  + hora + "  /  "  + dtc.getNickProfesor();
			//concat = dtc.getNombre() + "  /  " + dtc.getFecha() + "  /  "  + dtc.getHoraInicio();
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
	
	public DtClase[] listarDtClasesActividad(String institucion, String actividad) {
	    InstitucionDeportivaHandler instiHand = InstitucionDeportivaHandler.getInstancia();
        InstitucionDeportiva insti = instiHand.buscarInstitucionDeportiva(institucion);
        ActividadDeportiva acti = insti.buscarActividad(actividad);
        ArrayList<DtClase> clases = acti.obtenerClases();
        DtClase[] ret = new DtClase[clases.size()];
        int n=0;
        for(DtClase dtc: clases) {
            ret[n] = dtc;
            n++;
        }
        return ret;
	}	
	
	@Override
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
	
	@Override
	public Clase buscarClaseSeleccionada(String institucion, String actividad , String datClase) {
		String[] arr = datClase.split(" / ");
		String nombClase = arr [0];
		nombClase = nombClase.substring(0,nombClase.length()-1);
		System.out.println(nombClase+"/");
		Clase ret;
		InstitucionDeportivaHandler instiHand = InstitucionDeportivaHandler.getInstancia();
		InstitucionDeportiva insti = instiHand.buscarInstitucionDeportiva(institucion);
		ActividadDeportiva acti = insti.buscarActividad(actividad);
		ret = acti.buscarClase(nombClase);
		return ret;
	}
	
	@Override
    public DtClase buscarDtClaseSeleccionada(String institucion, String actividad , String datClase) {
        String[] arr = datClase.split(" / ");
        String nombClase = arr [0];
        nombClase = nombClase.substring(0,nombClase.length()-1);
        System.out.println(nombClase+"/");
        InstitucionDeportivaHandler instiHand = InstitucionDeportivaHandler.getInstancia();
        InstitucionDeportiva insti = instiHand.buscarInstitucionDeportiva(institucion);
        ActividadDeportiva acti = insti.buscarActividad(actividad);
        Clase ret = acti.buscarClase(nombClase);
        DtClase dtCla = ret.getDtClase();
        return dtCla;
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
		System.out.println(clase.getNombre() + "   " + socio.getNombre());
		if(this.usuarioRegistradoAClase(socio, clase)) {
			throw new RegistroClaseRepetidoException("El socio '" + socio.getNombre() + " " + socio.getApellido() + "' ya est\u00E1 registrado en esta clase.");
		}
		
		InstitucionDeportivaHandler instiHand = InstitucionDeportivaHandler.getInstancia();
        InstitucionDeportiva insti = instiHand.buscarInstitucionDeportiva(institucion);
        ActividadDeportiva acti = insti.buscarActividad(actividad);
        BigDecimal costo = acti.getCosto();
		
		Registro registro = new Registro(socio, clase, fechaReg, costo);
		System.out.println(registro.getSocio().getApellido() + "     " + registro.getClase().getNombre());
		socio.agregarRegistro(registro);
		clase.agregarRegistro(registro);
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		em.persist(socio);
		em.persist(clase);
		em.getTransaction().commit();
	}
	//nuevas para web
	
	@Override
	public Socio buscarSocio(String nickname) {
	    UsuarioHandler usuHand = UsuarioHandler.getInstancia();
        Socio socio = (Socio) usuHand.buscarUsuarioNick(nickname);
        return socio;
	}
	@Override
	public Clase buscarClase(String institucion, String actividad, String clase) {
        InstitucionDeportivaHandler instiHand = InstitucionDeportivaHandler.getInstancia();
        InstitucionDeportiva insti = instiHand.buscarInstitucionDeportiva(institucion);
        ActividadDeportiva acti = insti.buscarActividad(actividad);
        Clase ret = acti.buscarClase(clase);
        return ret;
	}
	
	
    @Override
    public void registroClaseWeb(String institucion, String actividad, String nombclase, String nickname, Date fechaReg) throws RegistroClaseRepetidoException {
        Socio socio = this.buscarSocio(nickname);
        Clase clase = this.buscarClase(institucion, actividad, nombclase);  
        if(this.usuarioRegistradoAClase(socio, clase)) {
            throw new RegistroClaseRepetidoException("El socio '" + socio.getNombre() + " " + socio.getApellido() + "' ya est\u00E1 registrado en esta clase.");
        }
        
        InstitucionDeportivaHandler instiHand = InstitucionDeportivaHandler.getInstancia();
        InstitucionDeportiva insti = instiHand.buscarInstitucionDeportiva(institucion);
        ActividadDeportiva acti = insti.buscarActividad(actividad);
        BigDecimal costo = acti.getCosto();
        
        Registro registro = new Registro(socio, clase, fechaReg, costo);
        System.out.println(registro.getSocio().getApellido() + "     " + registro.getClase().getNombre());
        socio.agregarRegistro(registro);
        clase.agregarRegistro(registro);
        Conexion conexion = Conexion.getInstancia();
        EntityManager em = conexion.getEntityManager();
        em.getTransaction().begin();
        em.persist(socio);
        em.persist(clase);
        em.getTransaction().commit();
    }
}

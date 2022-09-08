package logica;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class cargaDatos {
	
	
	public void cargarDatos() {
		this.cargarInstituciones();
		this.cargarActividades();
		this.cargarClases();
		this.cargarSocios();
		System.out.println("carga exitosa");
	}

	public void cargarInstituciones() {
		InstitucionDeportivaHandler instiHand = InstitucionDeportivaHandler.getInstancia();
		for(int i = 0; i<5; i++) {
			String name = "Institucion " + i;
			InstitucionDeportiva insti = new InstitucionDeportiva(name, "descrip...", "url....");
			instiHand.agregarInstitucionDeportiva(insti);
			//System.out.println("creada " + name);
		}
	}
	
	public void cargarSocios() {
		UsuarioHandler usuHand = UsuarioHandler.getInstancia();
		for(int i=0; i<5; i++) {
			String nik = "Socio" + i;
			String nom = "Nombre" + i;
			String ape = "Apellido" + i;
			String ema = "email" + i;
			Date fecha = new Date();
			Socio socio = new Socio( nik, nom, ape, ema, fecha);
			usuHand.agregarUsuario(socio);
			//System.out.println("socio" + nik + nom + ape);
		}
	}
	
	public void cargarActividades() {
		InstitucionDeportivaHandler instiHand = InstitucionDeportivaHandler.getInstancia();
		ArrayList<InstitucionDeportiva> instituciones = instiHand.obtenerInstitucionesObjeto();
		for(InstitucionDeportiva d: instituciones) {
			for(int i=0; i<5; i++) {
				String nom = "actividad" + i;
				String des = "lalala " + i;
				int dur = i;
				float costo = 100 + i;
				Date fecha = new Date();
				ActividadDeportiva nueva = new ActividadDeportiva( nom,  des,  dur,  costo,  fecha);
				d.agregarActividadDeportiva(nueva);
				//System.out.println("en " + d.getNombre() + " carga " + nueva.getNombre());
			}
		}
	}
	
	public void cargarClases() {
		InstitucionDeportivaHandler instiHand = InstitucionDeportivaHandler.getInstancia();
		ArrayList<InstitucionDeportiva> instituciones = instiHand.obtenerInstitucionesObjeto();
		for(InstitucionDeportiva d: instituciones) {
			ArrayList<ActividadDeportiva> actividades = d.obtenerActividadesObjeto();
				for(ActividadDeportiva a: actividades) {
					for(int i=0; i<5; i++) {
						String nombre = "clase" + i;
						Date fecha = new Date();
						Time horaInicio = new Time(5, 5, 5);
						String url = "www..." + i;
						Date fechaReg = new Date();
						Clase nueva = new Clase(nombre, fecha, horaInicio, url, fechaReg);
						a.agregarClase(nueva);						
						//System.out.println("en " + a.getNombre() + " carga " + nueva.getNombre());
					}
				}
		}
		
	}
	
}

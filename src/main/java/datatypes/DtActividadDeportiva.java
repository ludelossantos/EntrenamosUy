package datatypes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

public class DtActividadDeportiva {
	private String nombre;
	private String descripcion;
	private Float duracion;
	private BigDecimal costo;
	private Date fechaReg;
	private ArrayList<String> clasesAsociadasList = new ArrayList<>();

	public DtActividadDeportiva() {
		super();
	}

	public DtActividadDeportiva(String nombre, String descripcion, Float float1, BigDecimal bigDecimal, Date fechaReg) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracion = float1;
		this.costo = bigDecimal;
		this.fechaReg = fechaReg;
	}
	
	public DtActividadDeportiva(String nombre, String descripcion, Float duracion, BigDecimal costo, Date fechaReg, ArrayList<String> clasesAsociadasList) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.costo = costo;
		this.fechaReg = fechaReg;
		this.clasesAsociadasList = clasesAsociadasList;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Float getDuracion() {
		return duracion;
	}

	public BigDecimal getCosto() {
		return costo;
	}

	public Date getFechaReg() {
		return fechaReg;
	}
	
	public String getClasesAsociadas() {
		String aRetornar = new String("Clases asociadas");
		for(String s: clasesAsociadasList) {
			aRetornar = aRetornar + "\n\n" + s ;
		}

		return aRetornar;
	}
	
}
